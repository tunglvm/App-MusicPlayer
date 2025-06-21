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
        List<Playlist> playlists = playlistRepository.getAllPlaylists();
        model.addAttribute("playlists", playlists);
        model.addAttribute("playlist", new Playlist());
        return "playlist";
    }

    @PostMapping("/playlist")
    public String addPlaylist(@RequestParam String name) {
        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlistRepository.addPlaylist(playlist);
        return "redirect:/playlist";
    }

    @PostMapping("/playlist/update")
    public String updatePlaylist(@RequestParam int id, @RequestParam String name) {
        Playlist playlist = new Playlist();
        playlist.setId(id);
        playlist.setName(name);
        playlistRepository.updatePlaylist(playlist);
        return "redirect:/playlist";
    }

    @GetMapping("/playlist/delete/{id}")
    public String deletePlaylist(@PathVariable int id) {
        playlistRepository.deletePlaylist(id);
        return "redirect:/playlist";
    }
}