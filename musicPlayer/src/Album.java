public class Album {
    String albumTitle;
    String AlbumID;
    Songs songs;
    Artist Artist;
    String Songs;
    String Copyright;
    int albumDuration;

    public Album(String Title, String AlbumID, Artist Artist, String Songs, String Copyright, int Duration) {
        this.albumTitle = Title;
        this.AlbumID = AlbumID;
        this.Artist = Artist;
        this.Songs = Songs;
        this.Copyright = Copyright;
        this.albumDuration = Duration;
    }


    public static String getAlbumTitle(String AlbumID) {
        String test2 = AlbumID; 
        return test2;
    }

}




