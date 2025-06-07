package musicPlayer;

/**
 * Lưu thông tin giao dịch mua/thuê bài hát của người dùng.
 */
public class Transaction {
    private String transactionID;
    private String userID;
    private String songID;
    private String artistID;
    private String transactionType; // "buy" orU "rent"
    private String transactionDate;

    public Transaction(String transactionID, String userID, String songID, String artistID, String transactionType,
            String transactionDate) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.songID = songID;
        this.artistID = artistID;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSongID() {
        return songID;
    }

    public void setSongID(String songID) {
        this.songID = songID;
    }

    public String getArtistID() {
        return artistID;
    }

    public void setArtistID(String artistID) {
        this.artistID = artistID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
