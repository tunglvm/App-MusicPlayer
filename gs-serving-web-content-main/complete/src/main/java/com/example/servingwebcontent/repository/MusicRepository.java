package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    List<Music> findByTitleContainingIgnoreCase(String keyword);
}
