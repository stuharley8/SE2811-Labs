/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Lab1 Inheritance
 * Author: Stuart Harley
 * Created: 12/4/2019
 */

package harleys;

/**
 * Represents a plow that can be put on a vehicle
 */
public class Plow {

    private double plowWidth;

    /**
     * Constructor for a plow
     * @param plowWidth the width of the plow
     */
    public Plow(double plowWidth) {
        this.plowWidth = plowWidth;
    }

    public void setPlowWidth(double plowWidth) {
        this.plowWidth = plowWidth;
    }

    public double getPlowWidth() {
        return plowWidth;
    }
}
