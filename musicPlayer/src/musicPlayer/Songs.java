package musicPlayer;

public class Songs {
    private String songID;
    private String songTitle;
    private String genre;
    private int duration;
    private String artist;

    public Songs(String songID) {
        this.songID = songID;
    }


    //gettes, setters
    public void setSongInfo(String songTitle, String genre, int duration, String artist) {
        this.songTitle = songTitle;
        this.genre = genre;
        this.duration = duration;
        this.artist = artist;
    }

    public String getSongID() {
        return songID;
    }

    public String getSongTitle() {
        return songTitle;
    }

    // Bổ sung phương thức getTitle() để đồng bộ với PlayingSongs
    public String getTitle() {
        return songTitle;
    }

    public void setSongTitle(String newTitle) {
        this.songTitle = newTitle;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongInfo() {
        return songTitle + " - " + artist + " (" + genre + ", " + duration + "s)";
    }
}
