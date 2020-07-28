/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Bee Simulator
 * Author: Paul Rinaldi, Stuart Harley
 * Created: 12/16/2019
 */

package flowerbed_simulator;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Abstract Parent Class
 */
public abstract class Entity {
    protected static final double COLLISION_RADIUS = 10.0;
    protected static final double STANDARD_FIT_WIDTH = 50.0;
    private Location position;
    private ImageView imageView;

    /**
     * Entity Constructor
     * @param position the location of the entity
     * @param image an image to  associate with the entity
     */
    public Entity(Location position, Image image) {
        this.position = position;
        this.imageView = new ImageView(image);

        this.imageView.setX(position.getX());
        this.imageView.setY(position.getY());
        this.imageView.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
        this.imageView.setFitWidth(STANDARD_FIT_WIDTH);
    }

    public Location getPosition() {
        return position;
    }

    public void setPosition(Location position) {
        this.position = position;
    }

    /**
     * Adds this entity's ImageView to the given pane
     * @param pane the specified pane
     */
    public void setOnPane(Pane pane) {
        pane.getChildren().add(imageView);
    }

    /**
     * Removes an entity from the given pane
     * @param pane the specified pane
     */
    public void removeFromPane(Pane pane) {
        pane.getChildren().remove(imageView);
    }

    /**
     * Move ImageView to entity's current location
     */
    public final void updateImageViewLocation() {
        if (imageView != null) {
            imageView.setX(getPosition().getX());
            imageView.setY(getPosition().getY());
        }
    }

    /**
     * Calculates if two entities collide based on euclidean distance being inside a threshold
     * @param e - the other entity in the proposed collision
     * @return true if the entities collide
     */
    public boolean collides(Entity e) {
        double deltaX = this.getPosition().getX()
                - e.getPosition().getX();
        double deltaY = this.getPosition().getY()
                - e.getPosition().getY();
        double distanceBetweenEntities = Math.sqrt((deltaY*deltaY) + (deltaX*deltaX));

        return (distanceBetweenEntities < COLLISION_RADIUS);
    }
}
