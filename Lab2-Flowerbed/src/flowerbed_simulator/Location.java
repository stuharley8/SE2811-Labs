/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Bee Simulator
 * Author: Paul Rinaldi, Stuart Harley
 * Created: 12/16/2019
 */

package flowerbed_simulator;

import java.util.Random;

/**
 * Class represents a location with x and y coordinates
 */
public class Location {
    private static final double THRESHOLD = 0.01;
    private double x;
    private double y;

    /**
     * Location constructor
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Constructor that generates a random location within specified boundaries
     * @param rand a random object
     * @param width the max x value
     * @param height the max y value
     * @return a Location object with random x an y values
     */
    public static Location createRandomLocation(Random rand, double width, double height) {
        double x = (rand.nextDouble() * width) - Entity.STANDARD_FIT_WIDTH;
        double y = (rand.nextDouble() * height) - Entity.STANDARD_FIT_WIDTH;
        if (x < 0.0 + THRESHOLD) {
            x = Math.abs(x);
        }
        if (y < 0.0 + THRESHOLD) {
            y = Math.abs(y);
        }
        return new Location(x, y);
    }
}
