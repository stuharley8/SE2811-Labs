/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Bee Simulator
 * Author: Paul Rinaldi, Stuart Harley
 * Created: 12/16/2019
 */

package flowerbed_simulator;

import javafx.scene.image.Image;

/**
 * Class represents a Venus Fly Trap
 */
public class VenusFlower extends Flower {

    /**
     * Venus Flower constructor
     * @param position the location of the flower
     * @param image an image associated with the flower
     */
    public VenusFlower(Location position, Image image) {
        super(position, image);
    }
}
