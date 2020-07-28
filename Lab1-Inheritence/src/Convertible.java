/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Lab1 Inheritance
 * Author: Stuart Harley
 * Created: 12/4/2019
 */

package harleys;

/**
 * Class represents a convertible that extends car and can have a plow
 */
public class Convertible extends Car {

    // A plow is optional on a convertible. If no plow set plow to null.
    private Plow plow;

    /**
     * Constructor for a convertible
     * @param name the name of the vehicle
     * @param numWheels the number of wheels on the vehicle
     * @param weight the weight of the vehicle
     * @param plow the optional Plow of the vehicle
     */
    public Convertible(String name, int numWheels, double weight, Plow plow) {
        super(name, numWheels, weight);
        this.plow = plow;
    }

    /**
     * Lowers the plow if plow is not null
     * @return whether of not the plow is lowered
     */
    public boolean lowerPlow() {
        boolean lowered;
        if(plow == null) {
            System.out.println(getName() + " does not have a plow to lower");
            lowered = false;
        } else {
            System.out.println(getName() + " lowered its plow");
            lowered = true;
        }
        return lowered;
    }

    /**
     * Raises the plow if plow is not null
     * @return whether or not the plow is raised
     */
    public boolean raisePlow() {
        boolean raised;
        if(plow == null) {
            System.out.println(getName() + " does not have a plow to raise");
            raised = false;
        } else {
            System.out.println(getName() + " raised its plow");
            raised = true;
        }
        return raised;
    }

    /**
     * Lowers the roof
     * @return whether or not the roof is lowered
     */
    public boolean lowerRoof() {
        System.out.println(getName() + " lowered its roof");
        return true;
    }

    /**
     * Raises the roof
     * @return whether or not the roof is raised
     */
    public boolean raiseRoof() {
        System.out.println(getName() + " raised its roof");
        return true;
    }

    public void setPlow(Plow plow) {
        this.plow = plow;
    }

    public Plow getPlow() {
        return plow;
    }
}
