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
 * Represents a fully connected layer
 */
public class FullyConnectedLayer extends DecoratedLayer {

    /**
     * Constructor
     *
     * @param wrappedNetwork the previous network to be wrapped
     * @param numNodes       the number of nodes in the layer
     */
    public FullyConnectedLayer(Network wrappedNetwork, int numNodes) {
        super(wrappedNetwork, numNodes);
    }

    /**
     * Draws the entire network
     * @param canvas the canvas to be drawn on
     */
    @Override
    public void drawNetwork(Canvas canvas) {
        super.drawNetwork(canvas);
        for(Node node : this.getNodes()) {
            for(Node node2 : wrappedNetwork.getNodes()) {
                drawEdge(node, node2, canvas);
            }
        }
    }
}
