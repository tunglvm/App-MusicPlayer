package com.example.musicplayer.model;

import java.util.List;

public class Playlist {
    private Long id;
    private String name;
    private List<Song> songs;

    public Playlist() {}

    public Playlist(Long id, String name, List<Song> songs) {
        try {
            this.id = id;
            this.name = name;
            this.songs = songs;
        } catch (Exception e) {
            System.out.println("Lỗi khi tạo Playlist: " + e.getMessage());
        } finally {
            System.out.println("Khởi tạo Playlist hoàn tất.");
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Song> getSongs() { return songs; }
    public void setSongs(List<Song> songs) { this.songs = songs; }
}
