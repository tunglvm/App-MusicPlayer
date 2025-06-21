package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Song;
import com.example.servingwebcontent.repository.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SongController {
    private final SongRepository songRepository = new SongRepository();

    @GetMapping("/song")
    public String getSongPage(Model model) {
        List<Song> songs = songRepository.getAllSongs();
        model.addAttribute("songs", songs);
        model.addAttribute("song", new Song()); // Để binding form nếu dùng Thymeleaf
        return "song"; // song.html trong templates
    }

    @PostMapping("/song")
    public String addSong(
            @RequestParam String title,
            @RequestParam String artist,
            @RequestParam int duration,
            @RequestParam(required = false) String url // url có thể null
    ) {
        Song song = new Song();
        song.setTitle(title);
        song.setArtist(artist);
        song.setDuration(duration);
        song.setUrl(url);

        songRepository.addSong(song);

        return "redirect:/song";
    }
}