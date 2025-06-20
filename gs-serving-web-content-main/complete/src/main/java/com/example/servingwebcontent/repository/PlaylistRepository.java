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
                playlist.setId(rs.getLong("playlistId"));
                playlist.setName(rs.getString("name"));
                // playlist.setSongs(...) nếu cần lấy danh sách bài hát
                playlists.add(playlist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playlists;
    }
}