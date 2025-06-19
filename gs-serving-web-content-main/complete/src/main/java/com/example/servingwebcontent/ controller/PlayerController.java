package com.example.musicplayer.controller;

import com.example.musicplayer.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class PlayerController {

    @GetMapping("/player")
    public String player(Model model) {
        try {
            List<Song> songs = Arrays.asList(
                new Song(1L, "Bài hát 1", "/audio/song1.mp3"),
                new Song(2L, "Bài hát 2", "/audio/song2.mp3")
            );
            model.addAttribute("songs", songs);
        } catch (Exception e) {
            model.addAttribute("error", "Không tải được danh sách bài hát.");
        } finally {
            System.out.println("[GET] /player");
        }
        return "player";
    }
}
