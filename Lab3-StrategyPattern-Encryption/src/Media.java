/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Strategy-based Encryption
 * Author: Stuart Harley
 * Created: 12/18/2019
 */

package harleys;

/**
 * Class holds an encrypted message
 */
public class Media {

    private byte[] bytes; // represents the encrypted message

    /**
     * Default constructor
     */
    public Media() {
        bytes = new byte[0];
    }

    /**
     * Get method for bytes
     * @return bytes
     */
    public byte[] get() {
        return bytes;
    }

    /**
     * Set method for bytes
     * @param bytes the new byte array
     */
    public void set(byte[] bytes) {
        this.bytes = bytes;
    }

    /**
     * Returns bytes as a string as a series of space-separated bytes,
     * each coded as two hexadecimal places
     * @return the string
     */
    public String toString() {
        StringBuilder message = new StringBuilder();
        for(byte b : bytes) {
            message.append(String.format("%02x ", b));
        }
        return message.toString().substring(0, message.length()-1);
    }

    /**
     * Set method for bytes
     * @param str a string as a series of space-separated bytes,
     * each coded as two hexadecimal places
     */
    public void set(String str) {
        str = str.replaceAll("\\s", "");
        bytes = new byte[str.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(str.substring(index, index + 2), 16);
            bytes[i] = (byte) v;
        }
    }
}
