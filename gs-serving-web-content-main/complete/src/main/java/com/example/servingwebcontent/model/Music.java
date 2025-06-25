package com.example.servingwebcontent.model;

import javax.persistence.*;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private String url; // Đường dẫn file nhạc
    private String cover; // Link ảnh bìa

    // Constructors
    public Music() {}

    public Music(String title, String artist, String url, String cover) {
        this.title = title;
        this.artist = artist;
        this.url = url;
        this.cover = cover;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getCover() { return cover; }
    public void setCover(String cover) { this.cover = cover; }
}