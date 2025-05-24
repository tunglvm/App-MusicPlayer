public class Songs {
    private String songID;
    private String songTitle;
    private String genre;
    private int duration;

    public Songs(String songID) {
        this.songID = songID;
    }

    public void setSongInfo(String songTitle, String genre, int duration) {
        this.songTitle = songTitle;
        this.genre = genre;
        this.duration = duration;
    }

    // Getter & Setter cho SongsList
    public String getSongID() {
        return songID;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String newTitle) {
        this.songTitle = newTitle;
    }

    public String getSongInfo() {
        return songTitle + " (" + genre + ", " + duration + "s)";
    }
}
