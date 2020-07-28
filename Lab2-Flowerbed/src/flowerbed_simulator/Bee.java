/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Bee Simulator
 * Author: Paul Rinaldi, Stuart Harley
 * Created: 12/16/2019
 */

package flowerbed_simulator;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class represents a Bee
 */
public abstract class Bee extends Entity {
    /**
     * Types of Bees
     */
    public enum BeeType {
        /**
         * Types
         */
        RectangularMoveBee, TargetedMoveBee
    }
    protected static final double DELTA_MOVE = 5.0;
    private static final double HEALTH_BAR_HEIGHT = 5.0;
    private static final double HEALTH_BAR_MARGIN = 15.0;
    protected static final int MAX_HEALTH = 100;

    private Rectangle healthBar;
    private int energyPoints;

    /**
     * Bee Constructor
     *
     * @param position the location of the Bee
     * @param image an image to be associated with the Bee
     */
    public Bee(Location position, Image image) {
        super(position, image);
        energyPoints = MAX_HEALTH;
        this.healthBar = new Rectangle(STANDARD_FIT_WIDTH, HEALTH_BAR_HEIGHT, Color.RED);
        updateHealthBarLocationDisplay();
        updateHealthBarAmountDisplay();
    }

    /**
     * Checks if a Bee is in the same location as any other bees
     * @param bees a collection of bees to check the location against
     * @return the list of bees the Bee is touching (empty list if none)
     */
    public List<Bee> checkCollisionBee(Collection<Bee> bees) {
        if (this.energyPoints > 0) {
            List<Bee> touching = new ArrayList<>();
            for (Bee bee : bees) {
                if (this != bee && this.collides(bee)) {
                    touching.add(bee);
                }
            }
            return touching;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Checks if a Bee is in the same location as any flowers
     * @param flowers a collection of flowers to check the location against
     * @return the list of flowers the Bee is touching (empty list if none)
     */
    public List<Flower> checkCollisionFlower(Collection<Flower> flowers) {
        if (this.energyPoints > 0) {
            List<Flower> touching = new ArrayList<>();
            for (Flower flower : flowers) {
                if (this.collides(flower)) {
                    touching.add(flower);
                }
            }
            return touching;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Sets the energy points value and updates the Bee's healthbar
     * @param energyPoints the energy points
     * @param pane the pane
     */
    public void setEnergyPoints(int energyPoints, Pane pane) {
        this.energyPoints = energyPoints;
        updateHealthBarAmountDisplay();
        if(energyPoints <= 0) {
            die(pane);
        }
    }

    public int getEnergyPoints() {
        return this.energyPoints;
    }

    /**
     * Updates the energy points to zero for a collision with a venus flower
     * @param pane the pane
     */
    public void die(Pane pane) {
        this.energyPoints = 0;
        updateHealthBarAmountDisplay();
        removeFromPane(pane);
    }

    /**
     * Moves the Bee a set distance
     */
    public abstract void move();

    /**
     * Calculates the correct position for the health bar
     */
    public void updateHealthBarLocationDisplay() {
        this.healthBar.setX(getPosition().getX());
        this.healthBar.setY(getPosition().getY()-HEALTH_BAR_MARGIN); // above bee
    }

    /**
     * Updates the correct amount for the health bar
     */
    public void updateHealthBarAmountDisplay() {
        double healthPercent = ((double)this.energyPoints)/MAX_HEALTH;
        this.healthBar.setWidth(healthPercent * STANDARD_FIT_WIDTH);
    }

    /**
     * Adds this entity's ImageView to the given pane
     * @param pane the pane that the health bar will appear on
     */
    public void setHealthOnPane(Pane pane) {
        pane.getChildren().add(this.healthBar);
    }
}
