public class Single {
    String singleTitle;
    String singleID;
    Songs Song;
    String Artist;
    String Type;
    int singleDuration;

    public Single (String singleTitle, String singleID, String Artist, String Type, int Duration){
        this.singleTitle = singleTitle;
        this.singleID = singleID;
        this.Artist = Artist;
        this.Type = Type;
        this.singleDuration = Duration;
    }
    public void setSingleInfo(String singleTitle, String singleID, String Artist, String Type, int Duration){
        this.singleTitle = singleTitle;
        this.singleID = singleID;
        this.Artist = Artist;
        this.Type = Type;
        this.singleDuration = Duration;
    }
    public String getSingleInfo(){
        return this.singleTitle + " : " + this.singleDuration + " seconds";
    }
    public void displaySingleInfo() {
        System.out.println("Single Title: " + singleTitle);
        System.out.println("Single ID: " + singleID);
        System.out.println("Artist: " + Artist);
        System.out.println("Type: " + Type);
        System.out.println("Duration: " + singleDuration + " seconds");
    }
}
