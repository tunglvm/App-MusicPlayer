package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    // Có thể thêm các phương thức tùy chỉnh nếu cần sau này
}
