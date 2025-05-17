public class Songs {
    String songTitle;
    String SongID;
    String Artist;
    String Featuring;
    String Type;
    int songDuration;

    public Songs (String Title, String SongID, String Artist,String Featuring, String Type, int Duration){
        this.songTitle = Title;
        this.SongID = SongID;
        this.Artist = Artist;
        this.Featuring = Featuring;
        this.Type = Type;
        this.songDuration = Duration;

    }
    

    public static String getSongName(String Title){
        String songsTitle = Title;

        return songsTitle;
    }

    
}



