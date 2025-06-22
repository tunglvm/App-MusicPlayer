package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Song;
import com.example.servingwebcontent.database.aivenConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
    private aivenConnection db = new aivenConnection();

    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM song")) {
            while (rs.next()) {
                Song song = new Song();
                song.setId(rs.getLong("id"));
                song.setTitle(rs.getString("title"));
                song.setArtist(rs.getString("artist"));
                song.setDuration(rs.getInt("duration"));
                song.setUrl(rs.getString("url"));
                songs.add(song);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }

    public void addSong(Song song) {
        String sql = "INSERT INTO song (title, artist, duration, url) VALUES (?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, song.getTitle());
            stmt.setString(2, song.getArtist());
            stmt.setInt(3, song.getDuration());
            stmt.setString(4, song.getUrl());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSong(Song song) {
        String sql = "UPDATE song SET title = ?, artist = ?, duration = ?, url = ? WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, song.getTitle());
            stmt.setString(2, song.getArtist());
            stmt.setInt(3, song.getDuration());
            stmt.setString(4, song.getUrl());
            stmt.setLong(5, song.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSong(long id) {
        String sql = "DELETE FROM song WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}