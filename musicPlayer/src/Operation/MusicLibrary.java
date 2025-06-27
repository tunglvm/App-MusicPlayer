package Operation;

import musicPlayer.Songs;
import java.util.ArrayList;

public class MusicLibrary {
    private ArrayList<Songs> allSongs;

    public MusicLibrary() {
        this.allSongs = new ArrayList<>();
    }

    public void addSong(Songs song) {
        allSongs.add(song);
    }

    public void displaySongsByArtist(String artistName) {
        System.out.println("Songs by artist: " + artistName);
        boolean found = false;
        for (Songs song : allSongs) {
            if (song.getArtist().equalsIgnoreCase(artistName)) {
                System.out.println("- " + song.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No songs found for this artist.");
        }
    }

    // Test main
    public static void main(String[] args) {
        MusicLibrary library = new MusicLibrary();
        library.addSong(new Songs("S001"));
        library.allSongs.get(0).setSongInfo("Song A", "Pop", 200, "IU");
        library.addSong(new Songs("S002"));
        library.allSongs.get(1).setSongInfo("Song B", "Ballad", 180, "IU");
        library.addSong(new Songs("S003"));
        library.allSongs.get(2).setSongInfo("Song C", "Rock", 210, "Jack");

        library.displaySongsByArtist("IU");
        library.displaySongsByArtist("Jack");
        library.displaySongsByArtist("Jack");
        library.displaySongsByArtist("Sơn Tùng");
        library.displaySongsByArtist("Sơn Tùng");
    }
}