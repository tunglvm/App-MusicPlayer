public class Album {
    String albumTitle;
    String AlbumID;
    Songs songs;
    Artist Artist; 
    String Copyright;
    int albumDuration;

<<<<<<< HEAD
<<<<<<< HEAD
    public Album( String AlbumID) {

=======
    public Album(String albumTitle, String AlbumID, Artist Artist, Songs songs, String Copyright, int Duration) {
        this.albumTitle = albumTitle;
>>>>>>> 314e51f848e92d284d9f0333118fec0888f5e306
        this.AlbumID = AlbumID;

=======
    public Album(String albumTitle, String AlbumID, Artist Artist, Songs songs, String Copyright, int Duration) {
        this.albumTitle = albumTitle;
        this.AlbumID = AlbumID;
        this.Artist = Artist;
        this.songs = songs;
        this.Copyright = Copyright;
        this.albumDuration = Duration;
>>>>>>> 314e51f848e92d284d9f0333118fec0888f5e306
    }

    public void setAlbumInfo(String Title,Artist Artist, String Songs, String Copyright, int Duration){
        this.albumTitle = Title;
        this.Artist = Artist;
        this.songs = songs;
        this.Copyright = Copyright;
        this.albumDuration = Duration;
    }

}




