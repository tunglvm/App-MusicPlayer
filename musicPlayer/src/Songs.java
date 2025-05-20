public class Songs {
    String songTitle;
    String SongID;
    String Type;
    int songDuration;

    public Songs ( String SongID){
        this.SongID = SongID;

    }
    
    public void setSongInfo(String songTitle, String Type, int Duration){
        this.songTitle = songTitle;
        this.Type = Type;
        this.songDuration = Duration;
    }

    public String getSongInfo(){
        return this.songTitle + " : " + this.songDuration + " seconds";
    }
}



