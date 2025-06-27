package Operation;

import java.util.ArrayList;

public class DisplaySongsByAartist {
    private String title;
    private String artistName;

    public DisplaySongsByAartist(String title, String artistName) {
        try {
            this.title = title;
            this.artistName = artistName;
        } catch (Exception e) {
            System.out.println("Lỗi trong DisplaySongsByAartist Constructor: " + e.getMessage());
        }
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
        try {
            this.allSongs = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Lỗi trong MusicLibrary Constructor: " + e.getMessage());
        }
    }

    public void addSong(Song song) {
        try {
            if (song != null) {
                allSongs.add(song);
            } else {
                System.out.println("Không thể thêm bài hát, đối tượng song là null.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong addSong: " + e.getMessage());
        }
    }

    public void displaySongsByArtist(String artistName) {
        try {   
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
        } catch (Exception e) {
            System.out.println("Lỗi trong displaySongsByArtist: " + e.getMessage());
        }
    }
}

class Song {
    private String title;
    private String artistName;

    public Song(String title, String artistName) {
        try {
            this.title = title;
            this.artistName = artistName;
        } catch (Exception e) {
            System.out.println("Lỗi trong Song Constructor: " + e.getMessage());
        }
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }
}
