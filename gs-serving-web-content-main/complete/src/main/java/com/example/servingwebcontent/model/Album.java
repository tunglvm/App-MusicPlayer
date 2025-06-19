package com.example.musicplayer.model;

import java.util.List;

public class Album {
    private Long id;
    private String title;
    private List<Song> songs;

    public Album() {}

    public Album(Long id, String title, List<Song> songs) {
        try {
            this.id = id;
            this.title = title;
            this.songs = songs;
        } catch (Exception e) {
            System.out.println("Lỗi khi tạo Album: " + e.getMessage());
        } finally {
            System.out.println("Khởi tạo Album hoàn tất.");
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<Song> getSongs() { return songs; }
    public void setSongs(List<Song> songs) { this.songs = songs; }
}
