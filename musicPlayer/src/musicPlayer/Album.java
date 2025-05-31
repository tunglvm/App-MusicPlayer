package musicPlayer;

import java.util.List;

public class Album {
    private String albumID;
    private String albumTitle;
    private List<Songs> songs;

    public Album(String albumTitle, String albumID, List<Songs> songs) {
        this.albumTitle = albumTitle;
        this.albumID = albumID;
        this.songs = songs;
    }

    public String getAlbumID() {
        return albumID;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    // Thêm phương thức này để tương thích với PlayingSongs
    public String getAlbumName() {
        return albumTitle;
    }

    @Override
    public String toString() {
        return "Album: " + albumTitle + " (ID: " + albumID + "), Số bài hát: " +
                (songs != null ? songs.size() : 0);
    }
}
