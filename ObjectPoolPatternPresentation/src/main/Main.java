package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../gui/gui.fxml"));
        Parent rootNode = loader.load();

        stage.setResizable(false);
        stage.setScene(new Scene(rootNode));
        stage.setTitle("Simple Auction Simulator");

        stage.show();
/*      long startTime = System.nanoTime();
*       EncryptionKey key = new EncryptionKey();
*       long endTime = System.nanoTime();
*       System.out.println((endTime-startTime)/1000000);  // took about 500 milliseconds to run
*/
    }

}
