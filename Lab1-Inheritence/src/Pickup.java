/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Lab1 Inheritance
 * Author: Stuart Harley
 * Created: 12/4/2019
 */

package harleys;

/**
 * Class represents a pickup truck that extends truck
 */
public class Pickup extends Truck {

    /**
     * Constructor for a vehicle, has a non-null plow
     * @param name the name of the vehicle
     * @param numWheels the number of wheels on the vehicle
     * @param weight the weight of the vehicle
     * @param loadCapacity the load capacity of the truck
     * @param plow the plow
     */
    public Pickup(String name, int numWheels, double weight, double loadCapacity, Plow plow) {
        super(name, numWheels, weight, loadCapacity, plow);
    }
}
