package com.example.servingwebcontent.model;

public class Song {
    private Long id;
    private String title;
    private String artist;
    private int duration;
    private String url;

    // Constructor không tham số
    public Song() {}

    // Constructor đầy đủ 4 tham số
    public Song(Long id, String title, String artist, int duration, String url) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.url = url;
    }

    // Constructor 3 tham số (nếu chỉ cần id, title, artist)
    public Song(Long id, String title, String url) {
        this.id = id;
        this.title = title;
        this.artist = "";
        this.duration = 0; // hoặc giá trị mặc định
        this.url = url;
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

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }
}