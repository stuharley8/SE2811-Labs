/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Strategy-based Encryption
 * Author: Stuart Harley
 * Created: 12/18/2019
 */

package harleys;

/**
 * Interface dealing with different strategies of encryption
 */
public interface Encrypter {

    /**
     * Decrypts a message
     * @param bytes a byte array representing the encrypted message
     * @return a byte array representing the decrypted message
     */
    byte[] decrypt(byte[] bytes);

    /**
     * Encrypts a message
     * @param bytes a byte array representing the original message
     * @return a byte array representing the encrypted message
     */
    byte[] encrypt(byte[] bytes);
}
