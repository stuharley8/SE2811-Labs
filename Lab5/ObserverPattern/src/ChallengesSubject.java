/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 5: Tourists
 * Author:     Stuart Harley
 * Date:       29 Jan 2020
 */

package harleys;

import harleys.mobileEntities.MobileEntity;
import harleys.mobileEntities.Person;
import javafx.scene.layout.Pane;

/**
 * Concrete subject class from the observer pattern. Deals with challenges
 */
public class ChallengesSubject extends Subject {

    /**
     * Determines if the entity run into was a person, if so calls notifyObservers
     * @param taggable the taggable that was tagged
     * @param entity the entity to check if it is a person
     * @param pane the pane
     */
    public void changeState(Taggable taggable, MobileEntity entity, Pane pane) {
        if(entity instanceof Person) {
            pane.getChildren().clear();
            notifyObservers(taggable, pane);
        }
    }
}
