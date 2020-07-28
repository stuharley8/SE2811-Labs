/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Network Decorators
 * Author: Stuart Harley
 * Created: 1/18/2020
 */

package networks;

import javafx.scene.canvas.Canvas;

/**
 * Represents a layer of the network
 */
public class IdentityLayer extends DecoratedLayer {

    /**
     * Constructor
     * @param numNodes the number of nodes in the layer
     */
    public IdentityLayer(int numNodes) {
        super(null, numNodes);
    }

    /**
     * Draws the entire network
     * @param canvas the canvas to be drawn on
     */
    @Override
    public void drawNetwork(Canvas canvas) {
        for(Node node : this.getNodes()) {
            drawNode(node, canvas);
        }
    }

    /**
     * Draws the specified node
     * @param node   the specified node
     * @param canvas the canvas to be drawn on
     */
    @Override
    public void drawNode(Node node, Canvas canvas) {
        canvas.getGraphicsContext2D().strokeOval(node.getX()-RADIUS,
                node.getY()-RADIUS, 2*RADIUS, 2*RADIUS);
    }

    /**
     * Draws an edge between 2 nodes
     * @param node1  the first node
     * @param node2  the second node
     * @param canvas the canvas to be drawn on
     */
    @Override
    public void drawEdge(Node node1, Node node2, Canvas canvas) {
    }
}
