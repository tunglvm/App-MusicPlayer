public class Album {
    String AlbumTitle;
    String AlbumID;
    Songs songs;
    Artist Artist; 
    String Copyright;
    int albumDuration;

    public Album(String Title, String AlbumID, Artist Artist,Songs songs , String Copyright, int Duration) {
        this.AlbumID = AlbumID;
     }

    public void setAlbumInfo(String Title, Artist Artist,Songs songs , String Copyright, int Duration){
        this.AlbumTitle = Title;
        this.Artist = Artist;
        this.songs = songs;
        this.Copyright = Copyright;
        this.albumDuration = Duration;

    }

}




