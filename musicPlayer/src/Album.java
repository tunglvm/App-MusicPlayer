public class Album {
    String albumTitle;
    String AlbumID;
    Songs songs;
    Artist Artist;
    String Songs;
    String Copyright;
    int albumDuration;

    public Album( String AlbumID) {

        this.AlbumID = AlbumID;

    }

    public void setAlbumInfo(String Title,Artist Artist, String Songs, String Copyright, int Duration){
        this.albumTitle = Title;
        this.Artist = Artist;
        this.Songs = Songs;
        this.Copyright = Copyright;
        this.albumDuration = Duration;
    }

}




