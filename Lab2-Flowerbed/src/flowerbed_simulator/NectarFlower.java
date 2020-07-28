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
 * Class represents a Flower that can have nectar
 */
public class NectarFlower extends Flower {

    private boolean hasNectar;

    /**
     * Nectar Flower constructor
     * @param position the location of the flower
     * @param image and image associated with the flower
     */
    public NectarFlower(Location position, Image image) {
        super(position, image);
        hasNectar = true;
    }

    public void setHasNectar(boolean hasNectar) {
        this.hasNectar = hasNectar;
    }

    public boolean getHasNectar() {
        return hasNectar;
    }
}
