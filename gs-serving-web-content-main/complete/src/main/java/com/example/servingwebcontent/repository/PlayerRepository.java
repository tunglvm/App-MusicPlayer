package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Player;
import com.example.servingwebcontent.database.aivenConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    private aivenConnection db = new aivenConnection();

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM player")) {
            while (rs.next()) {
                Player player = new Player();
                player.setId(rs.getLong("playerId"));
                player.setName(rs.getString("name"));
                // Thêm các trường khác nếu có
                players.add(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
    }
}