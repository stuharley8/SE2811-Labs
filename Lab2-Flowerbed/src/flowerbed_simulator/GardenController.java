package flowerbed_simulator;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Controller class
 */
public class GardenController {

    private static final double MIN_WIDTH_HEIGHT = 150.0;
    private static final double MIN_WIDTH_HEIGHT_MULT = 150.0;
    private static final int TOTAL_NUM_BEES = 15;
    private static final int TOTAL_NUM_FLOWERS = 30;
    private static final String ASTER_FILENAME = "file:aster.png";
    private static final String VENUS_FILENAME = "file:venus.png";
    private static final String RECT_BEE_FILENAME = "file:bee-1.png";
    private static final String TARGET_BEE_FILENAME = "file:bee-2.png";
    private static final double BEE_TYPE_RATIO = .3;
    private static final double FLOWER_TYPE_RATIO = .7;
    private static final double WINDOW_THRESHOLD = 5.0;
    private static FlowerBed flowerBed;

    @FXML
    private Pane theGarden;

    /**
     * Initializes the GUI
     * @author Dr. Hasker, Paul Rinaldi
     */
    @FXML
    public void initialize() {
        theGarden.setStyle("-fx-background-color: linear-gradient(to bottom right," +
                "derive(forestgreen, 20%), derive(forestgreen, -40%));");
        theGarden.setFocusTraversable(true);

        // Initialize random
        Random random = new Random();
        long seed = System.currentTimeMillis();
        random.setSeed(seed);

        // Fill flowerbed
        ArrayList<Flower> flowers = generateFlowers(random);
        ArrayList<Bee> bees = generateBees(random, flowers);
        flowerBed = new FlowerBed(bees, flowers);
    }

    /**
     * Moves the bees and updates health when the right arrow key is pressed
     * @param keyEvent the keyEvent
     */
    @FXML
    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.RIGHT) {
            flowerBed.moveBees(theGarden);
            flowerBed.updateForCollisions(theGarden);
        }
    }

    private ArrayList<Flower> generateFlowers(Random random) {
        ArrayList<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < TOTAL_NUM_FLOWERS; i++) {
            Flower flower;
            double choiceOfFlower = random.nextDouble();
            Flower.FlowerType flowerType = choiceOfFlower >= BEE_TYPE_RATIO ?
                    Flower.FlowerType.NectarFlower : Flower.FlowerType.VenusFlower;
            flower = createRandomFlower(random, theGarden.getPrefWidth(),
                    theGarden.getPrefHeight(), flowerType);
            flowers.add(flower);
        }
        return flowers;
    }

    private ArrayList<Bee> generateBees(Random random, ArrayList<Flower> flowers) {
        ArrayList<Bee> bees = new ArrayList<>();
        for (int i = 0; i < TOTAL_NUM_BEES; i++) {
            Bee bee;
            double choiceOfBee = random.nextDouble();
            Bee.BeeType beeType = choiceOfBee >= FLOWER_TYPE_RATIO ?
                    Bee.BeeType.RectangularMoveBee : Bee.BeeType.TargetedMoveBee;
            bee = createRandomBee(random, theGarden.getPrefWidth(),
                    theGarden.getPrefHeight(), beeType, flowers);
            bees.add(bee);
            bee.setOnPane(theGarden);
            bee.setHealthOnPane(theGarden);
        }
        return bees;
    }

    private Flower createRandomFlower(Random rand, double width,
                                      double height, Flower.FlowerType flowerType) {
        Flower flower;
        Location newLocation = Location.createRandomLocation(rand, width, height);

        if (flowerType == Flower.FlowerType.VenusFlower) {
            flower = new VenusFlower(newLocation, new Image(VENUS_FILENAME));
        } else {
            flower = new NectarFlower(newLocation, new Image(ASTER_FILENAME));
        }
        flower.setOnPane(theGarden);
        return flower;
    }

    private Bee createRandomBee(Random rand, double width,
                                double height, Bee.BeeType beeType, List<Flower> flowers) {
        Bee bee;
        Location newLocation = Location.createRandomLocation(rand, width, height);
        if (beeType == Bee.BeeType.TargetedMoveBee) {
            Flower target = Flower.generateTargetFlower(rand, flowers, null);
            bee = new TargetedMoveBee(newLocation, target, new Image(TARGET_BEE_FILENAME));
        } else {
            double rectWidth = rand.nextDouble() * MIN_WIDTH_HEIGHT_MULT + MIN_WIDTH_HEIGHT;
            double rectLength = rand.nextDouble() * MIN_WIDTH_HEIGHT_MULT + MIN_WIDTH_HEIGHT;
            newLocation = calculateProperLocation(newLocation.getX(), newLocation.getY(), width, height, rectWidth, rectLength);
            bee = new RectangularMoveBee(newLocation,
                    rectWidth, rectLength, new Image(RECT_BEE_FILENAME));
        }
        return bee;
    }

    private Location calculateProperLocation(double x, double y, double width, double height, double moveWidth, double moveLength) {
        if (x > width - moveWidth - WINDOW_THRESHOLD) {
            x -= moveWidth;
        }
        if (y > height - moveLength - WINDOW_THRESHOLD) {
            y -= moveLength;
        }

        return new Location(x, y);
    }
}
