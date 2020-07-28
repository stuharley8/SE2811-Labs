/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Lab1 Inheritance
 * Author: Stuart Harley
 * Created: 12/4/2019
 */

package harleys;

/**
 * Abstract truck class that has a plow and extends vehicle
 */
public abstract class Truck extends Vehicle {

    private double loadCapacity;
    private Plow plow;

    /**
     * Constructor for a vehicle, has a non-null plow
     * @param name the name of the vehicle
     * @param numWheels the number of wheels on the vehicle
     * @param weight the weight of the vehicle
     * @param loadCapacity the load capacity of the truck
     * @param plow the plow
     */
    public Truck(String name, int numWheels, double weight, double loadCapacity, Plow plow) {
        super(name, numWheels, weight);
        this.loadCapacity = loadCapacity;
        this.plow = plow;
    }

    /**
     * Lowers the plow
     * @return whether of not the plow is lowered
     */
    public boolean lowerPlow() {
        System.out.println(getName() + " lowered its plow");
        return true;
    }

    /**
     * Raises the plow
     * @return whether or not the plow is raised
     */
    public boolean raisePlow() {
        System.out.println(getName() + " raised its plow");
        return true;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setPlow(Plow plow) {
        this.plow = plow;
    }

    public Plow getPlow() {
        return plow;
    }
}
