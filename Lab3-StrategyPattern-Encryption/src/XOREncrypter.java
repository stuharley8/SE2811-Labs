/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Strategy-based Encryption
 * Author: Stuart Harley
 * Created: 12/18/2019
 */

package harleys;

/**
 * Class represents an encryption strategy using exclusive-or
 */
public class XOREncrypter implements Encrypter {

    private byte[] key;

    /**
     * Constructor
     * @param key the key
     */
    public XOREncrypter(byte[] key) {
        this.key = key;
    }

    /**
     * Decrypts a message using exclusive-or
     *
     * @param bytes a byte array representing the encrypted message
     * @return a byte array representing the decrypted message
     */
    @Override
    public byte[] decrypt(byte[] bytes) {
        return encrypt(bytes);
    }

    /**
     * Encrypts a message using exclusive-or
     *
     * @param bytes a byte array representing the original message
     * @return a byte array representing the encrypted message
     */
    @Override
    public byte[] encrypt(byte[] bytes) {
        byte[] encrypted = new byte[bytes.length];
        int count = -1;
        for(int i = 0; i<bytes.length; i++) {
            count++;
            if(count == key.length) {
                count = 0;
            }
            encrypted[i] = (byte)(bytes[i] ^ key[count]);
        }
        return encrypted;
    }
}
