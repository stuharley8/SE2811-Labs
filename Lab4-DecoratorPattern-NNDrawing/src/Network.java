/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Network Decorators
 * Author: Stuart Harley
 * Created: 1/18/2020
 */

package networks;

import javafx.scene.canvas.Canvas;

import java.util.List;

/**
 * Interface represents the network
 */
public interface Network {

    /**
     * Represents the middle of the y-element of the canvas
     */
    double CANVAS_HEIGHT_MIDDLE = 325;

    /**
     * Represents the starting x-element for nodes in the canvas
     */
    double CANVAS_WIDTH_LOCATION = 75;

    /**
     * Represents the space in the y-element between nodes
     */
    double SPACE = 75;

    /**
     * Represents the radius of a node
     */
    double RADIUS = 15;

    /**
     * Draws the entire network
     *
     * @param canvas the canvas to be drawn on
     */
    void drawNetwork(Canvas canvas);

    /**
     * Draws the specified node
     *
     * @param node   the specified node
     * @param canvas the canvas to be drawn on
     */
    void drawNode(Node node, Canvas canvas);

    /**
     * Draws an edge between 2 nodes
     *
     * @param node1  the first node
     * @param node2  the second node
     * @param canvas the canvas to be drawn on
     */
    void drawEdge(Node node1, Node node2, Canvas canvas);

    /**
     * Returns the list of nodes
     *
     * @return the list of nodes
     */
    List<Node> getNodes();

    /**
     * Returns the number os layers in the network.
     * This simply returns the layer number of the network layer it is called on.
     * @return the layer number
     */
    int numLayers();

    /**
     * Gets the number of nodes in the input (1st) layer of the network
     * @return the number of nodes in the input layer
     */
    int inputSize();

    /**
     * Gets the number of nodes in the output (last) layer of the network.
     * This simply returns the number of nodes in the network layer it is called on.
     * @return the number of nodes in the output layer
     */
    int outputSize();
}
