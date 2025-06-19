package com.example.servingwebcontent.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private Long id;
    private String name;
    private List<Song> songs = new ArrayList<>();

    // Constructor đầy đủ
    public Playlist(Long id, String name, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.songs = songs;
    }

    // Constructor chỉ có name (tạo mới)
    public Playlist(String name) {
        this.name = name;
    }

    public Playlist() {
    }

    // Getter và Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
