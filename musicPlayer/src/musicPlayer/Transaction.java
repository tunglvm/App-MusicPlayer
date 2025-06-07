package musicPlayer;

public class Transaction {
    private String transactionID;
    private String userID;
    private String songID;
    // "buy" or "rent"
    private String transactionDate;
    private String artistID;



    public Transaction(String transactionID, String userID, String songID, String transactionDate, String artistID) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.songID = songID;
       
       
        this.artistID = artistID;
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

    public String getartistID() {
        return artistID;
    }

    public void setartistID(String artistID) {
        this.artistID = artistID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
    
}
