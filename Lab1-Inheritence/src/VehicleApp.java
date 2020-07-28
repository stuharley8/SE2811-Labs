/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Lab1 Inheritance
 * Author: Stuart Harley
 * Created: 12/4/2019
 */

package harleys;

/**
 * Contains main method
 */
public class VehicleApp {

    public static void main(String[] args) {
        Vehicle conv = new Convertible("Vehicle", 4, 1800, new Plow(23));
        conv.start();
        conv.goForward(10, 3);
        conv.goBackward(6, 2);
        conv.stop();
//      conv.raisePlow;
//      conv.lowerPlow;
        System.out.println();

        Car conv2 = new Convertible("Car", 5, 24, new Plow(13));
//      conv2.raisePlow;
//      conv2.lowerPlow;

        Convertible conv3 = new Convertible("Convertible", 4, 4522, null);
        conv3.start();
        conv3.goForward(60.5, 15.2);
        conv3.goBackward(10.7, 2.4);
        conv3.stop();
        conv3.raisePlow();
        conv3.lowerPlow();
        conv3.setPlow(new Plow(50.7));
        conv3.raisePlow();
        conv3.lowerPlow();
        conv3.raiseRoof();
        conv3.lowerRoof();
        System.out.println();

        Truck pickup = new Pickup("Pickup", 6, 1679, 79, new Plow(62));
        pickup.start();
        pickup.goForward(25, 5);
        pickup.goBackward(25, 7);
        pickup.stop();
//      pickup.raiseRoof();
//      pickup.lowerRoof();
        pickup.lowerPlow();
        pickup.raisePlow();
        System.out.println();

        Dumptruck dumptruck = new Dumptruck("Dumptruck", 16, 5500 ,1269, new Plow(100));
        dumptruck.start();
        dumptruck.goForward(5, 1);
        dumptruck.goBackward(2, .5);
        dumptruck.stop();
//      dumptruck.raiseRoof();
//      dumptruck.lowerRoof();
        dumptruck.lowerPlow();
        dumptruck.raisePlow();
        dumptruck.lowerLoad();
        dumptruck.raiseLoad();
    }
}
