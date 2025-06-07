package musicPlayer;

import java.util.ArrayList;

public class Album {
    private String albumID;
    private String title;
    private String artistName;
    private ArrayList<Songs> songs;
    private String publisher;
    private int duration;

    public Album(String albumID, String title, String artistName, ArrayList<Songs> songs, String publisher,
            int duration) {
        this.albumID = albumID;
        this.title = title;
        this.artistName = artistName;
        this.songs = songs;
        this.publisher = publisher;
        this.duration = duration;
    }

    public String getAlbumID() {
        return albumID;
    }

    public String getAlbumTitle() {
        return title;
    }

    public void setAlbumTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getAlbumInfo() {
        return "Album ID: " + albumID +
                ", Title: " + title +
                ", Artist: " + artistName +
                ", Publisher: " + publisher +
                ", Duration: " + duration + "s";
    }

    public ArrayList<Songs> getSongs() {
        return songs;
    }

    // Có thể bổ sung thêm các getter/setter khác nếu cần
}
