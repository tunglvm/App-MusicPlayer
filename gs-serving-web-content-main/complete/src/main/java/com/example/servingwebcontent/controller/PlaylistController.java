package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Playlist;
import com.example.servingwebcontent.repository.PlaylistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlaylistController {
    private final PlaylistRepository playlistRepository = new PlaylistRepository();

    @GetMapping("/playlist")
    public String getPlaylistPage(Model model) {
        try {
            List<Playlist> playlists = playlistRepository.getAllPlaylists();
            model.addAttribute("playlists", playlists);
            model.addAttribute("playlist", new Playlist());
            return "playlist";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi tải danh sách playlist!");
            return "error";
        }
    }

    @PostMapping("/playlist")
    public String addPlaylist(@RequestParam String name, Model model) {
        try {
            Playlist playlist = new Playlist();
            playlist.setName(name);
            playlistRepository.addPlaylist(playlist);
            return "redirect:/playlist";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi thêm playlist!");
            return "error";
        }
    }

    @PostMapping("/playlist/update")
    public String updatePlaylist(@RequestParam int id, @RequestParam String name, Model model) {
        try {
            Playlist playlist = new Playlist();
            playlist.setId(id);
            playlist.setName(name);
            playlistRepository.updatePlaylist(playlist);
            return "redirect:/playlist";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi cập nhật playlist!");
            return "error";
        }
    }

    @GetMapping("/playlist/delete/{id}")
    public String deletePlaylist(@PathVariable int id, Model model) {
        try {
            playlistRepository.deletePlaylist(id);
            return "redirect:/playlist";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi xóa playlist!");
            return "error";
        }
    }
}