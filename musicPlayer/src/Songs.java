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
        if (songTitle == null || songTitle.isEmpty()) {
            return "Song title is missing!";
        } else if (songDuration <= 0) {
            return "Song duration is unknown!";
        } else {
            return songTitle + " : " + songDuration + " seconds";
        }
    }
}



