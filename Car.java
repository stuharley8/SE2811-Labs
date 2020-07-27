/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Lab1 Inheritance
 * Author: Stuart Harley
 * Created: 12/4/2019
 */

package harleys;

/**
 * Abstract class that extends vehicle representing a car
 */
public abstract class Car extends Vehicle {

    /**
     * Constructor for a car
     * @param name the name of the vehicle
     * @param numWheels the number of wheels on the vehicle
     * @param weight the weight of the vehicle
     */
    public Car(String name, int numWheels, double weight) {
        super(name, numWheels, weight);
    }
}
