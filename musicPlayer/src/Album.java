import java.util.ArrayList;

public class Album {
    private String AlbumTitle;
    private String AlbumID;
    private Artist artist;
    private ArrayList<Songs> songsList;
    private String copyright;
    private int albumDuration;

    public Album(String albumTitle, String albumID, Artist artist, ArrayList<Songs> songsList, String copyright,
            int albumDuration) {
        this.AlbumTitle = albumTitle;
        this.AlbumID = albumID;
        this.artist = artist;
        this.songsList = songsList;
        this.copyright = copyright;
        this.albumDuration = albumDuration;
    }

    public String getAlbumTitle() {
        return AlbumTitle;
    }

    public String getAlbumID() {
        return AlbumID;
    }

    public Artist getArtist() {
        return artist;
    }

    public ArrayList<Songs> getSongsList() {
        return songsList;
    }

    public String getCopyright() {
        return copyright;
    }

    public int getAlbumDuration() {
        return albumDuration;
    }

    public String getAlbumInfo() {
        return AlbumTitle + " (" + songsList.size() + " songs, " + albumDuration + " seconds)";
    }

    public void displayAlbumInfo() {
        System.out.println("Album Title: " + AlbumTitle);
        System.out.println("Album ID: " + AlbumID);
        System.out.println("Artist: " + (artist != null ? artist.getName() : "Unknown"));
        System.out.println("Songs:");

        int index = 1;
        for (Songs s : songsList) {
            System.out.println(index + ". " + s.getSongInfo());
            index++;
        }

        System.out.println("Copyright: " + copyright);
        System.out.println("Duration: " + albumDuration + " seconds");
    }
}
