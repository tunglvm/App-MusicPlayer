package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Playlist;
import com.example.servingwebcontent.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepository;

    // Danh sách playlist
    @GetMapping
    public String listPlaylists(Model model) {
        try {
            model.addAttribute("playlists", playlistRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi lấy danh sách playlist: " + e.getMessage());
        }
        return "playlist";
    }

    // Hiển thị form thêm playlist
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("playlist", new Playlist());
        return "playlist_form";
    }

    // Xử lý thêm playlist
    @PostMapping("/add")
    public String addPlaylist(@ModelAttribute Playlist playlist, Model model) {
        try {
            playlistRepository.save(playlist);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi thêm playlist: " + e.getMessage());
            model.addAttribute("playlist", playlist);
            return "playlist_form";
        }
        return "redirect:/playlist";
    }

    // Hiển thị form sửa playlist
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            Optional<Playlist> playlist = playlistRepository.findById(id);
            if (playlist.isPresent()) {
                model.addAttribute("playlist", playlist.get());
                return "playlist_form";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi lấy thông tin playlist: " + e.getMessage());
        }
        return "redirect:/playlist";
    }

    // Xử lý sửa playlist
    @PostMapping("/edit/{id}")
    public String editPlaylist(@PathVariable Long id, @ModelAttribute Playlist playlist, Model model) {
        try {
            playlist.setId(id);
            playlistRepository.save(playlist);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi cập nhật playlist: " + e.getMessage());
            model.addAttribute("playlist", playlist);
            return "playlist_form";
        }
        return "redirect:/playlist";
    }

    // Xử lý xóa playlist
    @GetMapping("/delete/{id}")
    public String deletePlaylist(@PathVariable Long id) {
        try {
            playlistRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/playlist";
    }

    // Hiển thị danh sách bài hát trong playlist
    @GetMapping("/{id}/musics")
    public String showSongsInPlaylist(@PathVariable Long id, Model model) {
        try {
            Optional<Playlist> playlistOpt = playlistRepository.findById(id);
            if (playlistOpt.isPresent()) {
                Playlist playlist = playlistOpt.get();
                model.addAttribute("playlist", playlist);
                model.addAttribute("musics", playlist.getMusics());
                return "playlist_musics";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi lấy bài hát trong playlist: " + e.getMessage());
        }
        return "redirect:/playlist";
    }

    // Phát toàn bộ playlist
    @GetMapping("/{id}/play")
    @ResponseBody
    public String playAllSongs(@PathVariable Long id) {
        try {
            Optional<Playlist> playlistOpt = playlistRepository.findById(id);
            if (playlistOpt.isPresent()) {
                Playlist playlist = playlistOpt.get();
                return "Đang phát toàn bộ playlist: " + playlist.getName();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi khi phát playlist: " + e.getMessage();
        }
        return "Playlist không tồn tại!";
    }

    // Phát một bài hát cụ thể trong playlist
    @GetMapping("/{playlistId}/songs/{songIndex}/play")
    @ResponseBody
    public String playSongInPlaylist(@PathVariable Long playlistId, @PathVariable int songIndex) {
        try {
            Optional<Playlist> playlistOpt = playlistRepository.findById(playlistId);
            if (playlistOpt.isPresent()) {
                Playlist playlist = playlistOpt.get();
                if (playlist.getMusics() != null && songIndex >= 0 && songIndex < playlist.getMusics().size()) {
                    return "Đang phát: " + playlist.getMusics().get(songIndex).getTitle();
                }
                return "Bài hát không tồn tại!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi khi phát bài hát trong playlist: " + e.getMessage();
        }
        return "Playlist không tồn tại!";
    }

    // Phát ngẫu nhiên một bài hát trong playlist
    @GetMapping("/{id}/random/play")
    @ResponseBody
    public String playRandomSong(@PathVariable Long id) {
        try {
            Optional<Playlist> playlistOpt = playlistRepository.findById(id);
            if (playlistOpt.isPresent()) {
                Playlist playlist = playlistOpt.get();
                if (playlist.getMusics() == null || playlist.getMusics().isEmpty()) return "Playlist không có bài hát!";
                int idx = new java.util.Random().nextInt(playlist.getMusics().size());
                return "Đang phát ngẫu nhiên: " + playlist.getMusics().get(idx).getTitle();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi khi phát bài hát ngẫu nhiên: " + e.getMessage();
        }
        return "Playlist không tồn tại!";
    }
}
