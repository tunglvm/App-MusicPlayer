package com.example.musicplayer.controller;

import com.example.musicplayer.model.Playlist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/playlist")
public class PlaylistController {
    private List<Playlist> playlistList = new ArrayList<>();

    @GetMapping
    public String getAllPlaylists(Model model) {
        try {
            model.addAttribute("playlists", playlistList);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi lấy danh sách playlist");
        }
        return "playlist";
    }

    @PostMapping
    public String createPlaylist(@RequestParam String name) {
        try {
            playlistList.add(new Playlist(name));
        } catch (Exception e) {
            return "redirect:/playlist?error=1";
        }
        return "redirect:/playlist";
    }
}
