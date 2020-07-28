/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Bee Simulator
 * Author: Paul Rinaldi, Stuart Harley
 * Created: 12/16/2019
 */

package flowerbed_simulator;

import javafx.scene.image.Image;

import java.util.List;
import java.util.Random;

/**
 * Class represents a Flower
 */
public abstract class Flower extends Entity {
    public enum FlowerType {
        NectarFlower, VenusFlower
    }
    /**
     * Flower constructor
     * @param position the location of the flower
     * @param image an image associated with the flower
     */
    public Flower(Location position, Image image) {
        super(position, image);
    }

    /**
     * Generates a random flower from a list of flowers
     * @param rand a random object
     * @param flowers a list of flowers to choose from
     * @param lastTarget the last flower that was the target and so should not be picked again
     * @return a random flower
     */
    public static Flower generateTargetFlower(Random rand, List<Flower> flowers, Flower lastTarget) {
        Flower newTarget;
        do {
            int index = rand.nextInt(flowers.size());
            newTarget = flowers.get(index);
        } while (newTarget == lastTarget);

        return newTarget;
    }
}
