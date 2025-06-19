package com.example.musicplayer.controller;

import com.example.musicplayer.model.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private List<Album> albumList = new ArrayList<>();

    @GetMapping
    public String getAllAlbums(Model model) {
        try {
            model.addAttribute("albums", albumList);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi lấy danh sách album");
        }
        return "album";
    }

    @PostMapping
    public String createAlbum(@RequestParam String title) {
        try {
            albumList.add(new Album(title));
        } catch (Exception e) {
            return "redirect:/albums?error=1";
        }
        return "redirect:/albums";
    }
}
