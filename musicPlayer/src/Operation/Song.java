package Operation;

public class Song {
    private String title;
    private String artistName;

    public Song( String title, String artistName){
        this.title= title;
        this.artistName= artistName;
    }
    public String getArtistName(){
        return artistName;
    }

    public String getTitle(){
        return title;
    }

}
