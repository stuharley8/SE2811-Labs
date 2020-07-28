/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 5: Tourists
 * Author:     Stuart Harley
 * Date:       29 Jan 2020
 */

package harleys;

import harleys.mobileEntities.Car;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Arrays;

/**
 * Observer class dealing with finding words in license plates
 */
public class WordObserver implements Observer {

    private char[] goal;
    private char[] found;

    /**
     * Constructor
     * @param goal the word to be searched for
     */
    public WordObserver(String goal) {
        this.goal = goal.toCharArray();
        found = new char[goal.length()];
        for(int i = 0; i<goal.length(); i++) {
            found[i] = '*';
        }
    }

    /**
     * update method
     * @param taggable a taggable object
     * @param pane the pane
     */
    @Override
    public void update(Taggable taggable, Pane pane) {
        if(taggable instanceof Car) {
            char[] plate = ((Car) taggable).getPlate().toCharArray();
            for (char c : plate) {
                for (int j = 0; j < goal.length; j++) {
                    if (goal[j] == c) {
                        found[j] = goal[j];
                    }
                }
            }
        }
        pane.getChildren().add(new Label("Challenge: Find all the letters in "
                + String.copyValueOf(goal)));
        pane.getChildren().add(new Label("Goal: " + String.copyValueOf(goal)));
        pane.getChildren().add(new Label("Found: " + String.copyValueOf(found)));
        if(!Arrays.toString(found).contains("*")) {
            pane.getChildren().add(new Label(String.copyValueOf(goal) + " CHALLENGE COMPLETED"));
        }
        pane.getChildren().add(new Label(" "));
    }
}
