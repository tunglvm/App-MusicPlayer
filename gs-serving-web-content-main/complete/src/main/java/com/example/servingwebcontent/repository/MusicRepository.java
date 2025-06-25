package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Music;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Music, Long> {
}