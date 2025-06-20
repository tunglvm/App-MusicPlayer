package com.example.servingwebcontent.model;

public class Song {
    private Long id;
    private String title;
    private String artist;
    private int duration;

    // Constructor không tham số
    public Song() {}

    // Constructor đầy đủ 4 tham số
    public Song(Long id, String title, String artist, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    // Constructor 3 tham số (nếu chỉ cần id, title, artist)
    public Song(Long id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = 0; // hoặc giá trị mặc định
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

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
}