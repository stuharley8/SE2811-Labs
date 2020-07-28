/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Lab1 Inheritance
 * Author: Stuart Harley
 * Created: 12/4/2019
 */

package harleys;

/**
 * Abstract class represents a vehicle
 */
public abstract class Vehicle {

    private String name;
    private int numWheels;
    private double weight;

    /**
     * Constructor for a vehicle
     * @param name the name of the vehicle
     * @param numWheels the number of wheels on the vehicle
     * @param weight the weight of the vehicle
     */
    public Vehicle(String name, int numWheels, double weight) {
        this.name = name;
        this.numWheels = numWheels;
        this.weight = weight;
    }

    /**
     * Makes the vehicle go backward at a specified speed and acceleration
     * @param speed the speed
     * @param accel the acceleration
     */
    public void goBackward(double speed, double accel) {
        System.out.println(name + " is going backwards at " + speed +
                " speed and " + accel + " acceleration");
    }

    /**
     * Makes the vehicle go forward at a specified speed and acceleration
     * @param speed the speed
     * @param accel the acceleration
     */
    public void goForward(double speed, double accel) {
        System.out.println(name + " is going forwards at " + speed +
                " speed and " + accel + " acceleration");
    }

    /**
     * Starts the vehicle
     * @return whether or not the vehicle has started
     */
    public boolean start() {
        System.out.println(name + " started");
        return true;
    }

    /**
     * Stops the vehicle
     * @return whether or not the vehicle has stopped
     */
    public boolean stop() {
        System.out.println(name + " stopped");
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public double getWeight() {
        return weight;
    }
}
