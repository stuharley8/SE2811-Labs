package main;

/**
 * Represents a bid on the auction
 */
public class Bid {

    private String buyerName;
    private String bidPrice;
    private EncryptionKey key;

    public Bid(String buyerName, EncryptionKey key) {
        this.buyerName = buyerName;
        this.key = key;
    }

    public Bid(String buyerName) {
        this(buyerName, null);
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setKey(EncryptionKey key) {
        this.key = key;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public EncryptionKey getKey() {
        return key;
    }

    public void setBidPrice(String price) {
        this.bidPrice = price;
    }

    public String getBidPrice() {
        return bidPrice;
    }

}
