package com.example.musicplayer.model;

public class Song {
    private Long id;
    private String title;
    private String url;

    public Song() {}

    public Song(Long id, String title, String url) {
        try {
            this.id = id;
            this.title = title;
            this.url = url;
        } catch (Exception e) {
            System.out.println("Lỗi khi tạo Song: " + e.getMessage());
        } finally {
            System.out.println("Khởi tạo Song hoàn tất.");
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
