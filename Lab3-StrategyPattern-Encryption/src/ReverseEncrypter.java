/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Strategy-based Encryption
 * Author: Stuart Harley
 * Created: 12/18/2019
 */

package harleys;

/**
 * Class represents an encryption strategy using a reverse method
 */
public class ReverseEncrypter implements Encrypter {

    /**
     * Decrypts a message using reverse
     *
     * @param bytes a byte array representing the encrypted message
     * @return a byte array representing the decrypted message
     */
    @Override
    public byte[] decrypt(byte[] bytes) {
        return encrypt(bytes);
    }

    /**
     * Encrypts a message using reverse
     *
     * @param bytes a byte array representing the original message
     * @return a byte array representing the encrypted message
     */
    @Override
    public byte[] encrypt(byte[] bytes) {
        byte[] reverse = new byte[bytes.length];
        for(int i = 0; i < bytes.length; i++) {
            reverse[reverse.length-1-i] = bytes[i];
        }
        return reverse;
    }
}
