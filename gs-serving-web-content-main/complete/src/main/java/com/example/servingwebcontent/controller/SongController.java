package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Song;
import com.example.servingwebcontent.repository.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SongController {
    private final SongRepository songRepository;
    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/song")
    public String getSongPage(Model model) {
        List<Song> songs = songRepository.getAllSongs();
        model.addAttribute("songs", songs);
        model.addAttribute("song", new Song());
        return "song";
    }

    @PostMapping("/song")
    public String addSong(@RequestParam String title,
                          @RequestParam String artist,
                          @RequestParam int duration,
                          @RequestParam(required = false) String url) {
        Song song = new Song();
        song.setTitle(title);
        song.setArtist(artist);
        song.setDuration(duration);
        song.setUrl(url);
        songRepository.addSong(song);
        return "redirect:/song";
    }

    @PostMapping("/song/update")
    public String updateSong(@RequestParam int id,
                             @RequestParam String title,
                             @RequestParam String artist,
                             @RequestParam int duration,
                             @RequestParam(required = false) String url) {
        Song song = new Song();
        song.setId(id);
        song.setTitle(title);
        song.setArtist(artist);
        song.setDuration(duration);
        song.setUrl(url);
        songRepository.updateSong(song);
        return "redirect:/song";
    }

    @GetMapping("/song/delete/{id}")
    public String deleteSong(@PathVariable int id) {
        songRepository.deleteSong(id);
        return "redirect:/song";
    }
}