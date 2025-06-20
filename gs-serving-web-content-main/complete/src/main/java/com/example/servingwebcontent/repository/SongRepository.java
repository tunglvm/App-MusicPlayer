package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Song;
import com.example.servingwebcontent.database.aivenConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {
    private aivenConnection db = new aivenConnection();

    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM song")) {
            while (rs.next()) {
                Song song = new Song();
                song.setId(rs.getLong("songId")); // Đảm bảo tên cột đúng với DB
                song.setTitle(rs.getString("title"));
                song.setArtist(rs.getString("artist"));
                song.setDuration(rs.getInt("duration"));
                songs.add(song);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }

    public void addSong(Song song) {
        String sql = "INSERT INTO song (title, artist, duration) VALUES (?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, song.getTitle());
            stmt.setString(2, song.getArtist());
            stmt.setInt(3, song.getDuration());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}