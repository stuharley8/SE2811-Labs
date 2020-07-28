package main;

import com.sun.jdi.ClassNotPreparedException;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents the Object pool of bids
 */
public class BidPool {

    private Queue<Bid> bidPool = new LinkedList<>();
    private HashMap<EncryptionKey, String> keyCodes;
    private int nextBidNumber;

    /**
     * Creates a new BidPool with the specified number of bids
     *
     * @param number the number of bids in this Pool
     */
    public BidPool(int number) {
        keyCodes = new HashMap<>();
        nextBidNumber = 0;
        stockPool(number);
    }

    /**
     * Gets the next bid from the Pool
     *
     * @return a Bid from the Pool, else null, if no bids are available.
     */
    public synchronized Bid getBid() {
        return bidPool.poll();
    }

    /**
     * Recycles the specified Bid back into the pool
     *
     * @param bid the {@code Bid} to be recycled
     */
    public synchronized void recycleBid(Bid bid) {
        bid.setBuyerName("BID" + nextBidNumber);
        bidPool.offer(bid);
        nextBidNumber++;
    }

    /**
     * Returns the key code for the specified EncryptionKey in this BidPool
     *
     * @param key the Encryption Key to lookup
     * @return the keyCode for the specified EncryptionKey
     */
    public String getKeyCode(EncryptionKey key) {
        return keyCodes.get(key);
    }

    /**
     * Returns the number of bids in the pool
     *
     * @return the number of bids in the pool
     */
    public int bidsInPool() {
        return bidPool.size();
    }

    /**
     * Stocks the bidPool with the specified number of Bids
     *
     * @param number the number of bids to be stocked
     */
    private void stockPool(int number) {
        try {
            for (int i = 0; i < number; i++) {
                Bid bid = new Bid("BID" + nextBidNumber , new EncryptionKey());
                bidPool.offer(bid);
                keyCodes.put(bid.getKey(), String.valueOf(i));
                nextBidNumber++;
            }
        } catch (NoSuchAlgorithmException e) {
            throw new ClassNotPreparedException("Encryption Algorithm Not found");
        }
    }

}
