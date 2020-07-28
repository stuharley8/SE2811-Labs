/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 4: Decorators
 * Author: Dr. Yoder and Stuart Harley
 * Date: 1/18/2020
 */

package networks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;

import java.util.HashMap;
import java.util.Map;

/**
 * The controller for the main window.
 *
 * Also manages the networks.
 */
public class SimpleCanvasController {

    @FXML
    private Canvas canvas;

    private Map<String, Network> networks = new HashMap<>();

    @FXML
    private void showNetwork(ActionEvent actionEvent) {
        ToggleButton source = (ToggleButton)actionEvent.getSource();
        String id = source.getId();
        System.out.println("id = " + id);
        // Clear Canvas: https://stackoverflow.com/q/27203671/1048186
        GraphicsContext context = canvas.getGraphicsContext2D();
        System.out.println("canvas.getWidth() = " + canvas.getWidth());
        System.out.println("canvas.getHeight() = " + canvas.getHeight());
        context.setLineWidth(3);
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if(!networks.containsKey(id)) {
            System.out.println("Warning: Unknown network id:"+id);
        } else {
            System.out.println("DEBUG: Drawing network: "+id);
            Network network = networks.get(id);
            network.drawNetwork(canvas);
        }
    }

    @FXML
    private void initialize() {
        networks.put("alexLike", createAlexNet());
        networks.put("inceptionLike", createInception());
        networks.put("stuartLike", createStuartNet());
    }

    /**
     * As client code, use the decorator classes to construct the inception-like network,
     * as described in the lab.
     * @return network The network created.
     */
    private Network createInception() {
        Network identityLayer = new IdentityLayer(3);
        Network secondLayer = new ConvolutionalLayer(identityLayer);
        Network thirdLayer = new ConvolutionalLayer(secondLayer);
        return new ConvolutionalLayer(thirdLayer);
    }

    /**
     * As client code, use the decorator classes to construct the AlexNet-like network,
     * as described in the lab.
     * @return network The network created.
     */
    private Network createAlexNet() {
        Network identityLayer = new IdentityLayer(4);
        Network secondLayer = new ConvolutionalLayer(identityLayer);
        Network thirdLayer = new ConvolutionalLayer(secondLayer);
        Network fourthLayer = new FullyConnectedLayer(thirdLayer, 4);
        return new FullyConnectedLayer(fourthLayer, 3);
    }

    /**
     * As client code, use the decorator classes to construct a network of my own design.
     * @return the network created.
     */
    private Network createStuartNet() {
        Network identityLayer = new IdentityLayer(1);
        Network secondLayer = new FullyConnectedLayer(identityLayer, 8);
        Network thirdLayer = new FullyConnectedLayer(secondLayer, 5);
        Network fourthLayer = new ConvolutionalLayer(thirdLayer);
        Network fifthLayer = new FullyConnectedLayer(fourthLayer, 9);
        return new FullyConnectedLayer(fifthLayer, 1);
    }
}
