package Operation;

import java.util.ArrayList;
import java.util.Scanner;

public class DisplaySongsByAartist {
    private String title;
    private String artistName;

    public DisplaySongsByAartist(String title, String artistName) {
        this.title = title;
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getTitle() {
        return title;
    }
}

class MusicLibrary {
    private ArrayList<Song> allSongs;

    public MusicLibrary() {
        this.allSongs = new ArrayList<>();
    }

    public void addSong(Song song) {
        allSongs.add(song);
    }

    public void displaySongsByArtist(String artistName) {
        System.out.println("Songs by artist: " + artistName);
        boolean found = false;
        for (Song song : allSongs) {
            if (song.getArtistName().equalsIgnoreCase(artistName)) {
                System.out.println("- " + song.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No songs found for this artist.");
        }
    }
}

class Song {
    private String title;
    private String artistName;

    public Song(String title, String artistName) {
        this.title = title;
        this.artistName = artistName;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }
}