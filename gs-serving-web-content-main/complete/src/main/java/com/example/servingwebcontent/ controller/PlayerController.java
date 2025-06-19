package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class PlayerController {

    @GetMapping("/player")
    public String playSongs(Model model) {
        try {
            List<Song> songs = Arrays.asList(
                new Song(1L, "Bài hát 1", "/audio/song1.mp3"),
                new Song(2L, "Bài hát 2", "/audio/song2.mp3")
            );
            model.addAttribute("songs", songs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Hoàn tất xử lý PlayerController.");
        }
        return "player";
    }
}
