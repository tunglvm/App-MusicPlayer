public class Playlist {
    String playlistName;
    String playlistID;
    int numSongs;
    int playlistDuration;

    public Playlist(String playlistName, String playlistID, int numSongs, int playlistDuration){
        this.playlistName= playlistName;
        this.playlistID= playlistID;
        this.numSongs= numSongs;
        this.playlistDuration = playlistDuration;
    }
<<<<<<< HEAD
=======


    public String getPlaylistName(String playlistID){
        String test = playlistID;
        return test;
     }

>>>>>>> 5274d496b823ea4da5e30fa69b19eee4ec53ca82
}