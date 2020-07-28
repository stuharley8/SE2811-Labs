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
 * Class represents a Bee that moves in a rectangular clockwise pattern
 */
public class RectangularMoveBee extends Bee {
    private Direction direction;
    private Location startingPosition;
    private double width;
    private double length;

    private enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    /**
     * Rectangular Move Bee Constructor
     * @param position the location of the Bee
     * @param width the width of the rectangle the bee moves along
     * @param length the length of the rectangle the bee moves along
     * @param image an image to be associated with the bee
     */
    public RectangularMoveBee(Location position, double width, double length, Image image) {
        super(position, image);
        this.startingPosition = position;
        this.width = width;
        this.length = length;
        this.direction = Direction.RIGHT;
    }

    /**
     * Moves the Bee a set distance in its rectangular pattern
     */
    @Override
    public void move() {
        if (getEnergyPoints() > 0) {

            Location currentPosition = getPosition();
            double x = currentPosition.getX();
            double y = currentPosition.getY();

            double x0 = startingPosition.getX();
            double y0 = startingPosition.getY();

            double moveX = 0;
            double moveY = 0;

            switch (direction) {
                case RIGHT:
                    moveX += DELTA_MOVE;
                    if ((moveX + x) > (width + x0)) {
                        double surplusDelta = (moveX + x) - (width + x0);
                        moveY += surplusDelta;
                        direction = Direction.DOWN;
                    } else if ((moveX + x) == (width + x0)) {
                        direction = Direction.DOWN;
                    }
                    break;
                case DOWN:
                    moveY += DELTA_MOVE;
                    if ((moveY + y) > (length + y0)) {
                        double surplusDelta = (moveY + y) - (length + y0);
                        moveX -= surplusDelta;
                        direction = Direction.LEFT;
                    } else if ((moveY + y) == (length + y0)) {
                        direction = Direction.LEFT;
                    }
                    break;
                case LEFT:
                    moveX -= DELTA_MOVE;
                    if ((moveX + x) < (startingPosition.getX())) {
                        double surplusDelta = (moveX + x) - (x0);
                        moveY -= -surplusDelta;
                        direction = Direction.UP;
                    } else if ((moveX + x) == (startingPosition.getX())) {
                        direction = Direction.UP;
                    }
                    break;
                case UP:
                    moveY -= DELTA_MOVE;
                    if ((moveY + y) < (y0)) {
                        double surplusDelta = (moveY + y) - (y0);
                        moveX += -surplusDelta;
                        direction = Direction.RIGHT;
                    } else if ((moveY + y) == (y0)) {
                        direction = Direction.RIGHT;
                    }
                    break;
                default:
                    break;
            }

            setPosition(new Location(x + moveX, y + moveY));
            updateHealthBarLocationDisplay();
        }
    }
}
