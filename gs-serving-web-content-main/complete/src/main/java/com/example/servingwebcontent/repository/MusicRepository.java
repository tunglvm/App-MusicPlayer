package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Music;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MusicRepository {
    private final List<Music> musicList = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Music> findAll() {
        return musicList;
    }

    public Optional<Music> findById(Long id) {
        return musicList.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public void save(Music music) {
        try {
            if (music.getId() == null) {
                music.setId(idCounter++);
                musicList.add(music);
            } else {
                deleteById(music.getId());
                musicList.add(music);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi lưu bài hát: " + e.getMessage());
        }
    }

    public void deleteById(Long id) {
        try {
            musicList.removeIf(m -> m.getId().equals(id));
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa bài hát: " + e.getMessage());
        }
    }
}
