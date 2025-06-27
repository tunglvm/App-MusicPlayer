package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findByNameContainingIgnoreCase(String keyword);
}
