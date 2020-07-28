/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Bee Simulator
 * Author: Paul Rinaldi, Stuart Harley
 * Created: 12/16/2019
 */

package flowerbed_simulator;

import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Random;

/**
 * Class represents a Flower bed where bees and flowers can exist
 */
public class FlowerBed {
    private static final int ENERGY_POINTS_LOSE_COLLISION = 20;
    private static final int ENERGY_POINTS_LOSE_MOVE = 1;
    private static final int ENERGY_POINTS_GAIN_NECTAR = 100;

    private List<Bee> bees;
    private List<Flower> flowers;

    /**
     * Flower bed constructor
     * @param bees a collection of Bee objects
     * @param flowers a collection of Flower objects
     */
    public FlowerBed(List<Bee> bees, List<Flower> flowers) {
        this.bees = bees;
        this.flowers = flowers;
    }

    /**
     * Moves all the bees forward once
     * @param pane the pane
     */
    public void moveBees(Pane pane) {
        for(Bee bee : bees) {
            bee.move();
            bee.updateImageViewLocation();
            bee.setEnergyPoints(bee.getEnergyPoints() - ENERGY_POINTS_LOSE_MOVE, pane);
        }
    }

    /**
     * Checks if any entities are colliding and updates energy and nectar accordingly
     * @param pane the pane
     */
    public void updateForCollisions(Pane pane) {
        Random random = new Random();
        long seed = System.currentTimeMillis();
        random.setSeed(seed);
        for(Bee bee : bees) {
            List<Bee> collisionBees = bee.checkCollisionBee(bees);
            if(!collisionBees.isEmpty()) {
                bee.setEnergyPoints(bee.getEnergyPoints() - ENERGY_POINTS_LOSE_COLLISION, pane);
            }
            List<Flower> collisionFlowers = bee.checkCollisionFlower(flowers);
            for(Flower flower : collisionFlowers) {
                if(flower instanceof NectarFlower) {
                    if(((NectarFlower)flower).getHasNectar()) {
                        bee.setEnergyPoints(bee.getEnergyPoints()
                                + ENERGY_POINTS_GAIN_NECTAR, pane);
                        ((NectarFlower) flower).setHasNectar(false);
                    }
                    if (bee instanceof TargetedMoveBee) {
                        // find a new target for target bees
                        ((TargetedMoveBee) bee).setTarget(Flower.generateTargetFlower(random,
                                flowers, ((TargetedMoveBee) bee).getTarget()));
                    }
                } else if(flower instanceof VenusFlower) {
                    bee.die(pane);
                }
            }
        }
    }
}
