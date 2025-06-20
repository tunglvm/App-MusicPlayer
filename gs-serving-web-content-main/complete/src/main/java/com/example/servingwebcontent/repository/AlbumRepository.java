package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Album;
import com.example.servingwebcontent.database.aivenConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {
    private aivenConnection db = new aivenConnection();

    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM album")) {
            while (rs.next()) {
                Album album = new Album();
                album.setId(rs.getLong("albumId"));
                album.setName(rs.getString("albumName"));
                // album.setSongs(...) // Nếu cần, truy vấn riêng
                albums.add(album);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albums;
    }
}