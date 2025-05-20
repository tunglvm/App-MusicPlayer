public class Album {
    String albumTitle;
    String AlbumID;
    Songs songs;
    Artist Artist; 
    String Copyright;
    int albumDuration;

    public Album(String albumTitle, String AlbumID, Artist Artist, Songs songs, String Copyright, int Duration) {
        this.albumTitle = albumTitle;
        this.AlbumID = AlbumID;
        this.Artist = Artist;
        this.songs = songs;
        this.Copyright = Copyright;
        this.albumDuration = Duration;
    }


    public static String getAlbumTitle(String AlbumID) {
        String test2 = AlbumID; 
        return test2;
    }
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> ac7aa028b582e0fce845d447b37dfcfb26789113
=======
>>>>>>> ac7aa028b582e0fce845d447b37dfcfb26789113
}




