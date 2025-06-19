package com.example.musicplayer.controller;

import com.example.musicplayer.model.Playlist;
import com.example.musicplayer.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {
    private List<Playlist> playlistRepo = new ArrayList<>();

    @GetMapping
    public String listPlaylists(Model model) {
        try {
            model.addAttribute("playlists", playlistRepo);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi tải danh sách playlist");
        } finally {
            System.out.println("[GET] /playlists");
        }
        return "playlist";
    }

    @PostMapping
    public String addPlaylist(@RequestParam String name) {
        try {
            playlistRepo.add(new Playlist((long) (playlistRepo.size() + 1), name, new ArrayList<>()));
        } catch (Exception e) {
            System.out.println("Lỗi tạo playlist: " + e.getMessage());
        } finally {
            System.out.println("[POST] /playlists");
        }
        return "redirect:/playlists";
    }
}
