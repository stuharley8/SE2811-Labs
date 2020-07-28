/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 5: Tourists
 * Author:     Stuart Harley
 * Date:       29 Jan 2020
 */

package harleys;

import harleys.mobileEntities.Bus;
import javafx.scene.layout.Pane;

/**
 * Represents a Word Challenge Observer which is hidden until a bus is tagged
 */
public class HiddenWordObserver extends WordObserver {

    private boolean showing = false;

    /**
     * Constructor
     * @param goal the word to be searched for
     */
    public HiddenWordObserver(String goal) {
        super(goal);
    }

    public boolean isShowing() {
        return showing;
    }

    /**
     * update method
     * @param taggable a taggable object
     * @param pane the pane
     */
    @Override
    public void update(Taggable taggable, Pane pane) {
        if(!showing && taggable instanceof Bus) {
            showing = true;
        } else if(showing) {
            super.update(taggable, pane);
        }
    }
}
