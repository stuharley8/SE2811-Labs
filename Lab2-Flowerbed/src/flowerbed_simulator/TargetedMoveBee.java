/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Bee Simulator
 * Author: Paul Rinaldi, Stuart Harley
 * Created: 12/16/2019
 */

package flowerbed_simulator;

import javafx.scene.image.Image;

/**
 * Class represents a Bee that moves in a direct line to a targeted flower
 */
public class TargetedMoveBee extends Bee {

    private Flower target;

    /**
     * Targeted Bee Constructor
     * @param position the location of the Bee
     * @param target the targeted flower
     * @param image and image associated with the bee
     */
    public TargetedMoveBee(Location position, Flower target, Image image) {
        super(position, image);
        this.target = target;
    }

    /**
     * Moves the Bee a set distance towards the targeted flower
     */
    @Override
    public void move() {
        if (getEnergyPoints() > 0) {
            double x2 = target.getPosition().getX();
            double y2 = target.getPosition().getY();

            double x1 = getPosition().getX();
            double y1 = getPosition().getY();

            double moveX = 0;
            double moveY = 0;

            if (x2 > x1) {
                moveX += DELTA_MOVE;
            } else if (x2 < x1) {
                moveX -= DELTA_MOVE;
            }

            if (y2 > y1) {
                moveY += DELTA_MOVE;
            } else if (y2 < y1) {
                moveY -= DELTA_MOVE;
            }

            setPosition(new Location(moveX+x1, moveY+y1));
            updateHealthBarLocationDisplay();
        }
    }

    public void setTarget(Flower target) {
        this.target = target;
    }

    public Flower getTarget() {
        return this.target;
    }
}
