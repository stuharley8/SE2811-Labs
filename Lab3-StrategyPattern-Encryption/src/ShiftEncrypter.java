/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Strategy-based Encryption
 * Author: Stuart Harley
 * Created: 12/18/2019
 */

package harleys;

/**
 * Class represents an encryption strategy using a shift method
 */
public class ShiftEncrypter implements Encrypter {

    private static final byte MAX = (byte)256;
    private static final byte MIN = (byte)0;

    private int amount;

    /**
     * Constructor
     * @param amount the shift amount
     */
    public ShiftEncrypter(int amount) {
        this.amount = amount;
    }

    /**
     * Decrypts a message using shift
     *
     * @param bytes a byte array representing the encrypted message
     * @return a byte array representing the decrypted message
     */
    @Override
    public byte[] decrypt(byte[] bytes) {
        byte[] normal = new byte[bytes.length];
        for(int i = 0; i<bytes.length; i++) {
            normal[i] = (byte)(bytes[i]-amount);
            if(normal[i] <= MIN) {
                normal[i] = (byte)(normal[i]+MAX);
            }
        }
        return normal;
    }

    /**
     * Encrypts a message using shift
     *
     * @param bytes a byte array representing the original message
     * @return a byte array representing the encrypted message
     */
    @Override
    public byte[] encrypt(byte[] bytes) {
        byte[] shifted = new byte[bytes.length];
        for(int i = 0; i<bytes.length; i++) {
            shifted[i] = (byte)(bytes[i]+amount);
            if(shifted[i] >= MAX) {
                shifted[i] = (byte)(shifted[i]-MAX);
            }
        }
        return shifted;
    }
}
