/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Lab1 Inheritance
 * Author: Stuart Harley
 * Created: 12/4/2019
 */

package harleys;

/**
 * Class represents a dump truck that extends truck
 */
public class Dumptruck extends Truck {

    /**
     * Constructor for a vehicle, has a non-null plow
     * @param name the name of the vehicle
     * @param numWheels the number of wheels on the vehicle
     * @param weight the weight of the vehicle
     * @param loadCapacity the load capacity of the truck
     * @param plow the plow
     */
    public Dumptruck(String name, int numWheels, double weight, double loadCapacity, Plow plow) {
        super(name, numWheels, weight, loadCapacity, plow);
    }

    /**
     * Lowers the load
     * @return whether or not the load has been lowered
     */
    public boolean lowerLoad() {
        System.out.println(getName() + " lowered its load");
        return true;
    }

    /**
     * Raises the load
     * @return whether or not the load has been raised
     */
    public boolean raiseLoad() {
        System.out.println(getName() + " raised its load");
        return true;
    }
}
