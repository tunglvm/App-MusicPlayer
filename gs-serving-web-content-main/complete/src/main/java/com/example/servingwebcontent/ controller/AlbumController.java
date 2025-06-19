package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Album;
import com.example.servingwebcontent.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class AlbumController {

    @GetMapping("/album")
    public String showAlbums(Model model) {
        try {
            List<Song> songs = Arrays.asList(
                new Song(1L, "Bài hát A", "/audio/song1.mp3"),
                new Song(2L, "Bài hát B", "/audio/song2.mp3")
            );

            List<Album> albums = Arrays.asList(
                new Album(1L, "Album 1", songs),
                new Album(2L, "Album 2", songs)
            );

            model.addAttribute("albums", albums);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Tải album thành công.");
        }

        return "album";
    }
}
