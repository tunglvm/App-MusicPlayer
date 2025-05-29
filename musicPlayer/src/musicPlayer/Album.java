package musicPlayer;

import java.util.ArrayList;

public class Album {
    private String albumTitle;
    private String albumID;
    private Artist artist;
    private ArrayList<Songs> songsList;
    private String copyright;
    private int albumDuration;
    private ArrayList<Album> albums;


    public Album(String albumTitle, String albumID, Artist artist, ArrayList<Songs> songsList, String copyright,
            int albumDuration) {
        this.albumTitle = albumTitle;
        this.albumID = albumID;
        this.artist = artist;
        this.songsList = (songsList != null) ? songsList : new ArrayList<>();
        this.copyright = copyright;
        this.albumDuration = albumDuration;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumID() {
        return albumID;
    }

    public Artist getArtist() {
        return artist;
    }

    public ArrayList<Songs> getSongsList() {
        return songsList;
    }

    public void setSongsList(ArrayList<Songs> songsList) {
        this.songsList = songsList;
    }

    public String getCopyright() {
        return copyright;
    }

    public int getAlbumDuration() {
        return albumDuration;
    }

    public void setAlbumDuration(int albumDuration) {
        this.albumDuration = albumDuration;
    }

    public String getAlbumInfo() {
        return albumTitle + " (" + songsList.size() + " songs, " + albumDuration + " seconds)";
    }

    public void displayAlbumInfo() {
        System.out.println("Album Title: " + albumTitle);
        System.out.println("Album ID: " + albumID);
        System.out.println("Artist: " + (artist != null ? artist.getName() : "Unknown"));
        System.out.println("Songs:");

        int index = 1;
        if (songsList != null) {
            for (Songs s : songsList) {
                System.out.println(index + ". " + s.getSongInfo());
                index++;
            }
        }

        System.out.println("Copyright: " + copyright);
        System.out.println("Duration: " + albumDuration + " seconds");
    }
}
