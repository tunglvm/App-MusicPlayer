package com.example.servingwebcontent.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userID;
    private String userName;
    private String address;
    private List<Playlist> playlists = new ArrayList<>();

    // Constructor đầy đủ
    public User(String userID, String userName, String address, List<Playlist> playlists) {
        this.userID = userID;
        this.userName = userName;
        this.address = address;
        this.playlists = playlists;
    }

    // Constructor chỉ có userName (tạo mới)
    public User(String userName) {
        this.userName = userName;
    }

    public User() {}

    // Getter và Setter
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}