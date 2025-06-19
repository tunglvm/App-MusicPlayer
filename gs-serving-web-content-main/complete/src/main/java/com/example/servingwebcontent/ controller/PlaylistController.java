package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Playlist;
import com.example.servingwebcontent.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class PlaylistController {

    @GetMapping("/playlist")
    public String viewPlaylist(Model model) {
        try {
            List<Song> songs = Arrays.asList(
                new Song(1L, "Bài hát A", "/audio/a.mp3"),
                new Song(2L, "Bài hát B", "/audio/b.mp3")
            );
            Playlist playlist = new Playlist(1L, "Playlist yêu thích", songs);
            model.addAttribute("playlist", playlist);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Hoàn tất xử lý PlaylistController.");
        }
        return "playlist";
    }
}
