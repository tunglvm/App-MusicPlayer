package com.example.servingwebcontent;

// Song.java

public class Song {
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
