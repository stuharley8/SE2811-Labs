/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 5: Tourists
 * Author:     Stuart Harley
 * Date:       29 Jan 2020
 */

package harleys;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject class from the Observer Pattern
 */
public abstract class Subject {

    private List<Observer> observers;

    /**
     * Constructor
     */
    public Subject() {
        this.observers = new ArrayList<>();
    }

    /**
     * Adds a observer to the list of observers
     * @param observer the observer to add
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes a specified observer from the list of observers
     * @param observer the specified observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies the observers when the event occurs that the subject is watching for
     * @param taggable a taggable object
     * @param pane a pane
     */
    public void notifyObservers(Taggable taggable, Pane pane){
        for(Observer observer : observers) {
            observer.update(taggable, pane);
        }
    }
}
