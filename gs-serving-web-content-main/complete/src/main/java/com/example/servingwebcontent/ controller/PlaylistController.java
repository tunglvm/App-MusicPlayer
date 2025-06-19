package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Playlist;
import com.example.servingwebcontent.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlaylistController {

    private List<Playlist> playlistList = new ArrayList<>();

    @GetMapping("/playlist")
    public String getPlaylistPage(Model model) {
        model.addAttribute("playlists", playlistList);
        return "playlist";
    }

    @PostMapping("/playlist")
    public String addPlaylist(@RequestParam String name, Model model) {
        try {
            playlistList.add(new Playlist(1L, name, new ArrayList<Song>()));
            model.addAttribute("playlists", playlistList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Xử lý thêm playlist hoàn tất.");
        }
        return "playlist";
    }
}
