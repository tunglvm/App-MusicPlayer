package com.example.servingwebcontent.model;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private Long id;
    private String title;
    private List<Song> songs = new ArrayList<>();

    // Constructor đầy đủ
    public Album(Long id, String title, List<Song> songs) {
        this.id = id;
        this.title = title;
        this.songs = songs;
    }

    // Constructor chỉ có title
    public Album(String title) {
        this.title = title;
    }

    public Album() {
    }

    // Getter và Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
