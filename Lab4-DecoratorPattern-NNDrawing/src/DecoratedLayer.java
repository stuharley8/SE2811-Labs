/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Network Decorators
 * Author: Stuart Harley
 * Created: 1/18/2020
 */

package networks;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a layer added on top to a network
 */
public abstract class DecoratedLayer implements Network {

    protected Network wrappedNetwork;
    private List<Node> nodes;
    private int layerNumber;

    /**
     * Constructor
     * @param wrappedNetwork the previous network to be wrapped
     * @param numNodes the number of nodes in the layer
     */
    public DecoratedLayer(Network wrappedNetwork, int numNodes) {
        this.wrappedNetwork = wrappedNetwork;
        if(wrappedNetwork!=null) {
            this.layerNumber = wrappedNetwork.numLayers() + 1;
        } else {
            layerNumber = 1;
        }
        nodes = new ArrayList<>();
        if(numNodes%2==0) {
            double offest = (numNodes-2.0)/2*SPACE+SPACE/2;
            for(int i = 0; i < numNodes; i++) {
                nodes.add(new Node(CANVAS_WIDTH_LOCATION*layerNumber,
                         CANVAS_HEIGHT_MIDDLE-offest+SPACE*i));
            }
        } else {
            double offset = (numNodes-1.0)/2*SPACE;
            for(int i = 0; i < numNodes; i++) {
                nodes.add(new Node(CANVAS_WIDTH_LOCATION*layerNumber,
                        CANVAS_HEIGHT_MIDDLE-offset + SPACE*i));
            }
        }
    }

    @Override
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * Returns the number os layers in the network.
     * This simply returns the layer number of the network layer it is called on.
     * @return the layer number
     */
    @Override
    public int numLayers() {
        return layerNumber;
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
     * Draw edge between two nodes.
     * @param node1 the first node
     * @param node2 the second node
     * @param canvas the canvas to be drawn on
     */
    @Override
    public void drawEdge(Node node1, Node node2, Canvas canvas) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        Point2D p1 = new Point2D(node1.getX(), node1.getY());
        Point2D p2 = new Point2D(node2.getX(), node2.getY());
        Point2D direction = p2.subtract(p1).normalize();
        Point2D radius = direction.multiply(RADIUS);
        Point2D start = p1.add(radius);
        Point2D end = p2.subtract(radius);
        context.strokeLine(start.getX(), start.getY(), end.getX(), end.getY());
    }

    /**
     * Draws the entire network
     * @param canvas the canvas to be drawn on
     */
    @Override
    public void drawNetwork(Canvas canvas) {
        wrappedNetwork.drawNetwork(canvas);
        for(Node node : nodes) {
            drawNode(node, canvas);
        }
    }

    /**
     * Gets the number of nodes in the input (1st) layer of the network
     * @return the number of nodes in the input layer
     */
    @Override
    public int inputSize() {
        DecoratedLayer temp = this;
        while(temp.wrappedNetwork != null) {
            temp = (DecoratedLayer)temp.wrappedNetwork;
        }
        return temp.nodes.size();
    }

    /**
     * Gets the number of nodes in the output (last) layer of the network.
     * This simply returns the number of nodes in the network layer it is called on.
     * @return the number of nodes in the output layer
     */
    @Override
    public int outputSize() {
        return nodes.size();
    }
}
