package musicPlayer;
public class Playlist {
    private String playlistName;
    private String playlistID;
    private int numSongs;
    private int playlistDuration;

    public Playlist(String playlistName, String playlistID, int numSongs, int playlistDuration) {
        this.playlistName = playlistName;
        this.playlistID = playlistID;
        this.numSongs = numSongs;
        this.playlistDuration = playlistDuration;
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


    public String toString() {
        return "Playlist: " + playlistName + " | ID: " + playlistID +
               " | Number of songs: " + numSongs +
               " | Duration: " + playlistDuration + "s";
    }
}
