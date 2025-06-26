package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    // Có thể thêm các phương thức tìm playlist theo tên, user... nếu cần sau này
}
