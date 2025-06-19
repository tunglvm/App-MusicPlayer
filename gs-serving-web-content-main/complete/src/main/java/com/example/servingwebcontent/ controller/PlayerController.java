package com.example.musicplayer.controller;

import com.example.musicplayer.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @GetMapping
    public String playMusic(Model model) {
        try {
            List<Song> songs = Arrays.asList(
                new Song("Bai hat 1", "/audio/song1.mp3"),
                new Song("Bai hat 2", "/audio/song2.mp3")
            );
            model.addAttribute("songs", songs);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi phát nhạc");
        }
        return "player";
    }
}
