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
    public String viewAlbum(Model model) {
        try {
            List<Song> songs = Arrays.asList(
                new Song(1L, "Ca khúc X", "/audio/x.mp3"),
                new Song(2L, "Ca khúc Y", "/audio/y.mp3")
            );
            Album album = new Album(1L, "Album Xuân Hè", songs);
            model.addAttribute("album", album);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Hoàn tất xử lý AlbumController.");
        }
        return "album";
    }
}
