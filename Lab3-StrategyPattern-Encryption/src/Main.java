/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Strategy-based Encryption
 * Author: Stuart Harley
 * Created: 12/18/2019
 */

package harleys;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Class contains the main method
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CrypStick crypStick = new CrypStick();
        System.out.print("E)ncrypt or D)ecrypt: ");
        String input = in.nextLine().toLowerCase();
        if (!(input.equals("e") || input.equals("d"))) {
            return; // Incorrect input, ends the program
        }
        System.out.print("Method (rev, shift, xor): ");
        String method = in.nextLine().toLowerCase();
        String key;
        int shift;
        switch (method) {
            case "xor":
                System.out.print("Key: ");
                key = in.nextLine();
                crypStick.setEncryptionStrategy(
                        new XOREncrypter(key.getBytes(StandardCharsets.UTF_8)));
                break;
            case "shift":
                System.out.print("Shift amount: ");
                shift = in.nextInt();
                crypStick.setEncryptionStrategy(new ShiftEncrypter(shift));
                in.nextLine();
                break;
            case "rev":
                crypStick.setEncryptionStrategy(new ReverseEncrypter());
                break;
            default:
                return; // Incorrect input, ends the program
        }
        System.out.println("Message: ");
        StringBuilder message = new StringBuilder();
        if (input.equals("e")) {
            crypStick.setEncrypt(true);
            while (in.hasNextLine()) {
                message.append(in.nextLine());
                message.append("\n");
            }
        } else {
            crypStick.setEncrypt(false);
            while (in.hasNextLine()) {
                message.append(in.nextLine());
            }
        }
        crypStick.setMessage(message.toString());
        System.out.println(crypStick.getMessage());
    }
}
