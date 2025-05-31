package musicPlayer;

import java.util.List;

public class Playlist {
    private String playlistName;
    private String playlistID;
    private int numSongs;
    private int playlistDuration; // đơn vị: giây
    private List<Songs> songs; // Thêm thuộc tính này

    public Playlist(String playlistName, String playlistID, int numSongs, int playlistDuration) {
        this.playlistName = playlistName;
        this.playlistID = playlistID;
        this.numSongs = numSongs;
        this.playlistDuration = playlistDuration;
    }

    // Thêm constructor nếu muốn truyền vào danh sách bài hát
    public Playlist(String playlistName, String playlistID, List<Songs> songs) {
        this.playlistName = playlistName;
        this.playlistID = playlistID;
        this.songs = songs;
        this.numSongs = (songs != null) ? songs.size() : 0;
        this.playlistDuration = 0; // Có thể tính tổng thời lượng nếu muốn
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistID() {
        return playlistID;
    }

    public int getNumSongs() {
        return numSongs;
    }

    public void setNumSongs(int numSongs) {
        this.numSongs = numSongs;
    }

    public int getPlaylistDuration() {
        return playlistDuration;
    }

    public void setPlaylistDuration(int playlistDuration) {
        this.playlistDuration = playlistDuration;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
        this.numSongs = (songs != null) ? songs.size() : 0;
    }

    @Override
    public String toString() {
        return "Playlist: " + playlistName +
                " (ID: " + playlistID + "), " +
                numSongs + " bài hát, " +
                playlistDuration + " giây";
    }
}
