package com.example.musicplayer.controller;

import com.example.musicplayer.model.Album;
import com.example.musicplayer.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private List<Album> albums = new ArrayList<>();

    @GetMapping
    public String listAlbums(Model model) {
        try {
            model.addAttribute("albums", albums);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tải danh sách album");
        } finally {
            System.out.println("[GET] /albums");
        }
        return "album";
    }

    @PostMapping
    public String addAlbum(@RequestParam String title) {
        try {
            albums.add(new Album((long) (albums.size() + 1), title, new ArrayList<>()));
        } catch (Exception e) {
            System.out.println("Lỗi tạo album: " + e.getMessage());
        } finally {
            System.out.println("[POST] /albums");
        }
        return "redirect:/albums";
    }
}
