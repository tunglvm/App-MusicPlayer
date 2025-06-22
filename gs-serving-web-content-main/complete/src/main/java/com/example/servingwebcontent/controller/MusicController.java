package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Song;
import com.example.servingwebcontent.repository.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MusicController {
    private final SongRepository songRepository;

    public MusicController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/music")
    public String getMusicPage(Model model) {
        List<Song> songs = songRepository.getAllSongs();
        model.addAttribute("songs", songs);
        model.addAttribute("song", new Song());
        return "music";
    }

    @PostMapping("/music/song")
    public String addSongFromMusic(@RequestParam String title,
                                   @RequestParam String artist,
                                   @RequestParam int duration,
                                   @RequestParam(required = false) String url) {
        Song song = new Song();
        song.setTitle(title);
        song.setArtist(artist);
        song.setDuration(duration);
        song.setUrl(url);
        songRepository.addSong(song);
        return "redirect:/music";
    }

    @GetMapping("/music/song/delete/{id}")
    public String deleteSongFromMusic(@PathVariable long id) {
        songRepository.deleteSong(id);
        return "redirect:/music";
    }
}