package com.example.servingwebcontent.model;

public class Song {
    private Long id;
    private String title;
    private String filePath;

    // Constructor đầy đủ
    public Song(Long id, String title, String filePath) {
        this.id = id;
        this.title = title;
        this.filePath = filePath;
    }

    // Constructor không có id (dành cho trường hợp tạo mới)
    public Song(String title, String filePath) {
        this.title = title;
        this.filePath = filePath;
    }

    public Song() {
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
