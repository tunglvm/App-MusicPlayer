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

public class DisplaySongsByArtist {
    public static void main(String[] args) {
        MusicLibrary library = new MusicLibrary();

        // Sample data
        library.addSong(new Song("Yesterday", "IU"));
        library.addSong(new Song("ONLY", "LeeHi"));
        library.addSong(new Song("Magic Shop", "BTS"));
        library.addSong(new Song("Epiphany", "BTS"));
        library.addSong(new Song("Blueming", "IU"));
         library.addSong(new Song("Gone", "ROSÉ"));
        library.addSong(new Song("BREATHE", "LeeHi"));
        library.addSong(new Song("Circle", "SEVENTEEN"));


        Scanner sc = new Scanner(System.in);
        System.out.print("Artist name: ");
        String artistName = sc.nextLine();

        library.displaySongsByArtist(artistName);
    }
}
