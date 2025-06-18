// MusicLibrary.java
package com.example.servingwebcontent;

import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {
    private List<Song> allSongs = new ArrayList<>();

    public void addSong(Song song) {
        if (song != null) {
            allSongs.add(song);
        }
    }

    public List<String> displaySongsByArtist(String artistName) {
        List<String> songTitles = new ArrayList<>();
        for (Song song : allSongs) {
            if (song.getArtistName().equalsIgnoreCase(artistName)) {
                songTitles.add(song.getTitle());
            }
        }
        return songTitles.isEmpty() ? List.of("No songs found for this artist.") : songTitles;
    }
}
