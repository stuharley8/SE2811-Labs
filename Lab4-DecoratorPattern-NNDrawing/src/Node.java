/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Network Decorators
 * Author: Stuart Harley
 * Created: 1/18/2020
 */

package networks;

/**
 * Class represents a node of the network
 */
public class Node {

    private double x;
    private double y;

    /**
     * Constructor
     * @param x the x location
     * @param y the y location
     */
    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
