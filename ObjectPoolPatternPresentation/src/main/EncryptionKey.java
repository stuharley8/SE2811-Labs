package main;

import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class EncryptionKey {

    private Key key;

    /**
     * Constructor generates encryption key
     */
    public EncryptionKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        key = keyGen.generateKeyPair().getPrivate();
    }

    @Override
    public boolean equals(Object o) {
        try {
            return Objects.equals(key, ((EncryptionKey)o).key);
        } catch (ClassCastException e) {
           return false;
        }
    }

    /**
     *
     * @return a hash code for this object
     */
    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

}
