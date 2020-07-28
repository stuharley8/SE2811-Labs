/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 5: Tourists
 * Author:     Stuart Harley
 * Date:       29 Jan 2020
 */

package harleys;

import javafx.scene.layout.Pane;

/**
 * Observer interface from the Observer pattern
 */
public interface Observer {

    /**
     * update method
     * @param taggable a taggable object
     * @param pane the pane
     */
    void update(Taggable taggable, Pane pane);
}
