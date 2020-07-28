package gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Bid;
import main.BidPool;
import main.CircularArrayIterator;

import java.text.DecimalFormat;
import java.util.Iterator;

public class Controller {

    private static DecimalFormat priceFormat = new DecimalFormat("000.00");

    @FXML
    private Label bidAmount;
    @FXML
    private ImageView itemView;
    @FXML
    private TextArea console;
    @FXML
    private TextField bidders;
    @FXML
    private TextField bidsInPool;

    private Iterator<Image> productImages;

    private Thread[] bidderThreads;
    private BidPool bidPool;

    /**
     * Performs initial setup operations
     */
    public void initialize() {
        loadImages();
        bidderThreads = new Thread[0];
        bidPool = new BidPool(0);

        bidAmount.setText("$000.00");
        console.setText("Auction Simulator Initialized\nWelcome");
    }

    /**
     * Updates the attributes for the auction
     *
     * @param actionEvent
     */
    @FXML
    private void updateAttributes(ActionEvent actionEvent) {
        interruptRunningThreads();

        String consoleOutput = "";

        try {
            int input = Integer.parseInt(bidsInPool.getText());
            if (input < 0) {
                showErrorMessage("Number of bids in pool must not be negative.");
            } else {
                bidPool = new BidPool(input);
                consoleOutput = "Number of bids set to: " + bidsInPool.getText() + "\n";
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid number of bids in pool: " + bidsInPool.getText());
        }

        try {
            int input = Integer.parseInt(bidders.getText());
            if (input < 0) {
                showErrorMessage("Number of bidders must not be negative.");
            } else {
                bidderThreads = new Thread[input];
                consoleOutput += "Number of bidders set to: " + bidders.getText();
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid number of bidders: " + bidders.getText());
        }

        console.setText(consoleOutput);
    }

    /**
     * The method that actually starts the auction simulation running. This method is only
     * executed when the auction first starts, and reconfigures the button handler to skip
     * this step. A more elegant approach than using a boolean and if statement to detect
     * whether this is the first execution.
     *
     * @param actionEvent the action event from the button that starts the simulation
     */
    @FXML
    private void startAuctions(ActionEvent actionEvent) {
        Button startButton = (Button) actionEvent.getSource();
        startButton.setText("Next Auction");
        startButton.setOnAction(this::nextAuction);
        nextAuction(actionEvent);
    }

    /**
     * Advances the auction to the next item
     *
     * @param actionEvent the action even that triggered this
     */
    public void nextAuction(ActionEvent actionEvent) {
        interruptRunningThreads();
        bidAmount.setText("$000.00");

        itemView.setImage(productImages.next());
        console.setText("Recycling Bids...\n" +
                "Bidding window now open:"
        );

        // I set up these bidder threads in one loop, then executed them in another to try to keep
        // them starting at approximately the same time. While the "fuses" for them do *have* to be
        // lit sequentially, it's the best we can do.

        // Setup the bidder threads
        for (int i = 0; i < bidderThreads.length; i++) {
            bidderThreads[i] = new Thread(new Bidder());
        }

        // Execute the bidder threads
        for (Thread thread : bidderThreads) {
            thread.start();
        }
    }

    private synchronized void makeBid(Bid bid) {

        String bidName = bid.getBuyerName();

        Platform.runLater(() -> console.setText(console.getText() + "\nID: " + bidName +
                "\t\tAMT: " + bid.getBidPrice() + "\t\tKEY: " + bidPool.getKeyCode(bid.getKey())));

        Platform.runLater(() -> {
            if (Double.parseDouble(bid.getBidPrice()) >
                    Double.parseDouble(bidAmount.getText().substring(1))) {
                bidAmount.setText("$" + bid.getBidPrice());
            }
        });
    }

    /**
     * Loads all of the images for the auction the filesystem for the
     */
    private void loadImages() {

        // We load these images with the async parameter set to true, and just won't worry about
        // when they load because this program is a toy.
        Image[] images = {
                new Image("gui/resources/item1.jpg", true),
                new Image("gui/resources/item2.jpg", true),
                new Image("gui/resources/item3.jpg", true),
                new Image("gui/resources/item4.jpg", true),
                new Image("gui/resources/item5.jpg", true),
                new Image("gui/resources/item6.jpg", true),
                new Image("gui/resources/item7.jpg", true),
                new Image("gui/resources/item8.jpg", true),
                new Image("gui/resources/item9.jpg", true),
                new Image("gui/resources/item10.jpg", true),
                };
        productImages = new CircularArrayIterator<>(images);
    }

    private void interruptRunningThreads() {
        for (Thread thread : bidderThreads) {
            if (thread != null && thread.isAlive()) {
                thread.interrupt();
            }
        }
    }

    /**
     * Shows an error message
     *
     * @param contentText the text for the error message
     */
    private void showErrorMessage(String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    /**
     * The thread for a bidder
     */
    private class Bidder implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            try {
                Bid bid;
                int waitTime = (int) (Math.random() * 2000);
                do {
                    Thread.sleep(waitTime);
                    bid = bidPool.getBid();
                    // If no bids are available, ask again until one is available
                } while (bid == null);
                bid.setBidPrice(priceFormat.format(Math.random() * 1000));
                makeBid(bid);
                bidPool.recycleBid(bid);

            } catch (InterruptedException e) {
                // consume -- When the thread is interrupted, just end it
            }
        }

    }

}
