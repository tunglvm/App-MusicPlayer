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
                album.setId(rs.getLong("id"));
                album.setName(rs.getString("name"));
                albums.add(album);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albums;
    }

    public void addAlbum(Album album) {
        String sql = "INSERT INTO album (name) VALUES (?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, album.getName());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAlbum(Album album) {
        String sql = "UPDATE album SET name = ? WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, album.getName());
            stmt.setLong(2, album.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAlbum(long id) {
        String sql = "DELETE FROM album WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}