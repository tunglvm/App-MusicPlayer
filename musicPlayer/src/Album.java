public class Album {
    String albumTitle;
    String AlbumID;
    Songs songs;
    Artist Artist; 
    String Copyright;
    int albumDuration;

    public Album(String Title, String AlbumID, Artist Artist,Songs songs , String Copyright, int Duration) {
        this.albumTitle = Title;
        this.AlbumID = AlbumID;
        this.Artist = Artist;
        this.songs = songs;
        this.Copyright = Copyright;
        this.albumDuration = Duration;
    }

}




