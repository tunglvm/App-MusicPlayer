package com.example.servingwebcontent;

public class Playlist {
    private String name;
    private String id;
    private int numSongs;
    private int duration; // đơn vị: giây

    public Playlist(String name, String id, int numSongs, int duration) {
        this.name = name;
        this.id = id;
        this.numSongs = numSongs;
        this.duration = duration;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public int getNumSongs() { return numSongs; }
    public int getDuration() { return duration; }
}