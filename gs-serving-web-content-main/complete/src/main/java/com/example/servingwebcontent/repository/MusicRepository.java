package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MusicRepository {
    private final List<Song> songs = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public List<Song> getAllSongs() {
        return new ArrayList<>(songs);
    }

    public void addSong(Song song) {
        song.setId(idGen.getAndIncrement());
        songs.add(song);
    }

    public void deleteSong(long id) {
        Iterator<Song> it = songs.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                break;
            }
        }
    }
}