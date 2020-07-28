/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 5: Tourists
 * Author:     Dr. Yoder and Stuart Harley
 * Date:       29 Jan 2020
 */

package harleys;

import javafx.geometry.Point2D;
import harleys.mobileEntities.MobileEntity;

/**
 * Simple interface for all taggable objects.
 *
 * The CityMap uses this class to simplify collision detection.  See the CityMap's taggedBy method.
 */
public interface Taggable {

    /**
     * @param location The location to check
     * @return true if this object was tagged by touching that location
     */
    boolean isTagged(Point2D location);

    /**
     * Respond to being tagged. This method is called when the object is tagged.
     * @param entity The entity performing the tagging.
     */
    void taggedBy(MobileEntity entity);
}
