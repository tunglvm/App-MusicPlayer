package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Music;
import com.example.servingwebcontent.model.Playlist;
import com.example.servingwebcontent.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepository;

    // Danh sách tất cả playlist
    @GetMapping
    public String listPlaylists(Model model) {
        try {
            List<Playlist> playlists = playlistRepository.findAll();
            model.addAttribute("playlists", playlists);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi lấy danh sách playlist: " + e.getMessage());
        }
        return "playlist";
    }

    // Form thêm playlist
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("playlist", new Playlist());
        return "playlist_form";
    }

    // Xử lý thêm
    @PostMapping("/add")
    public String addPlaylist(@ModelAttribute Playlist playlist, Model model) {
        try {
            playlistRepository.save(playlist);
            return "redirect:/playlist";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi thêm playlist: " + e.getMessage());
            return "playlist_form";
        }
    }

    // Form sửa playlist
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Playlist> opt = playlistRepository.findById(id);
        if (opt.isPresent()) {
            model.addAttribute("playlist", opt.get());
            return "playlist_form";
        }
        return "redirect:/playlist";
    }

    // Xử lý sửa
    @PostMapping("/edit/{id}")
    public String editPlaylist(@PathVariable Long id, @ModelAttribute Playlist playlist, Model model) {
        try {
            playlist.setId(id);
            playlistRepository.save(playlist);
            return "redirect:/playlist";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi cập nhật playlist: " + e.getMessage());
            return "playlist_form";
        }
    }

    // Xóa playlist
    @GetMapping("/delete/{id}")
    public String deletePlaylist(@PathVariable Long id) {
        try {
            playlistRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/playlist";
    }

    // ✅ Danh sách bài hát trong playlist
    @GetMapping("/{id}/musics")
    public String showSongsInPlaylist(@PathVariable Long id, Model model) {
        Optional<Playlist> opt = playlistRepository.findById(id);
        if (opt.isPresent()) {
            Playlist playlist = opt.get();
            List<Music> musics = playlist.getMusics() != null ? playlist.getMusics() : new ArrayList<>();
            model.addAttribute("playlist", playlist);
            model.addAttribute("musics", musics);
            return "playlist_musics";
        }
        return "redirect:/playlist";
    }
}
