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
 * Represents a convolutional layer
 */
public class ConvolutionalLayer extends DecoratedLayer {

    /**
     * Constructor
     * @param wrappedNetwork the previous network to be wrapped
     */
    public ConvolutionalLayer(Network wrappedNetwork) {
        super(wrappedNetwork, wrappedNetwork.getNodes().size());
    }

    /**
     * Draws the entire network
     * @param canvas the canvas to be drawn on
     */
    @Override
    public void drawNetwork(Canvas canvas) {
        super.drawNetwork(canvas);
        for(int i = 0; i<this.getNodes().size(); i++) {
            drawEdge(this.getNodes().get(i), wrappedNetwork.getNodes().get(i), canvas);
        }
    }
}
