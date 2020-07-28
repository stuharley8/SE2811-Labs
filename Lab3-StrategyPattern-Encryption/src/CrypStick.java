/*
 * Course: SE2811-011
 * Winter 2019
 * Lab: Strategy-based Encryption
 * Author: Stuart Harley
 * Created: 12/18/2019
 */

package harleys;

import java.nio.charset.StandardCharsets;

/**
 * A portable device for carrying secure messages
 */
public class CrypStick {

    private Encrypter encrypter;
    private Media media;
    private boolean encrypt;

    protected Media getMedia(){
        return media;
    }

    /**
     * Default Constructor
     */
    public CrypStick() {
        encrypter = null;
        media = new Media();
        encrypt = false;
    }

    /**
     * Uses the encrypter to return the encrypted/decrypted message
     * @return the message as a string
     */
    public String getMessage() {
        String message;
        if(encrypt) {
            media.set(encrypter.encrypt(media.get()));
            message = media.toString();
        } else {
            media.set(encrypter.decrypt(media.get()));
            message = new String(media.get(), StandardCharsets.UTF_8);
        }
        return message;
    }

    public void setEncryptionStrategy(Encrypter encrypter) {
        this.encrypter = encrypter;
    }

    /**
     * Sets a message in the internal media
     * @param str the message
     */
    public void setMessage(String str) {
        if(encrypt) {
            StringBuilder builder = new StringBuilder();
            for (char c : str.toCharArray()) {
                builder.append(String.format("%02x ", (byte) c));
            }
            str = builder.toString();
        }
        media.set(str);
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }
}
