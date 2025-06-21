package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Playlist;
import com.example.servingwebcontent.database.aivenConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {
    private aivenConnection db = new aivenConnection();

    public List<Playlist> getAllPlaylists() {
        List<Playlist> playlists = new ArrayList<>();
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM playlist")) {
            while (rs.next()) {
                Playlist playlist = new Playlist();
                playlist.setId(rs.getLong("id"));
                playlist.setName(rs.getString("name"));
                playlists.add(playlist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playlists;
    }

    public void addPlaylist(Playlist playlist) {
        String sql = "INSERT INTO playlist (name) VALUES (?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, playlist.getName());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePlaylist(Playlist playlist) {
        String sql = "UPDATE playlist SET name = ? WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, playlist.getName());
            stmt.setLong(2, playlist.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePlaylist(long id) {
        String sql = "DELETE FROM playlist WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}