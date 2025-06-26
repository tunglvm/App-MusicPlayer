package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Music;
import com.example.servingwebcontent.model.Playlist;
import com.example.servingwebcontent.repository.MusicRepository;
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

    @Autowired
    private MusicRepository musicRepository;

    private List<Music> playQueue = new ArrayList<>();
    private int currentIndex = 0;

    // Danh sách playlist
    @GetMapping
    public String listPlaylists(Model model) {
        model.addAttribute("playlists", playlistRepository.findAll());
        return "playlist";
    }

    // Hiển thị form thêm playlist mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("playlist", new Playlist());
        model.addAttribute("musics", musicRepository.findAll());
        return "playlist_form";
    }

    // Xử lý thêm playlist
    @PostMapping("/add")
    public String addPlaylist(@ModelAttribute Playlist playlist, @RequestParam("musicIds") List<Long> musicIds) {
        try {
            List<Music> musics = musicRepository.findAllById(musicIds);
            playlist.setMusics(musics);
            playlistRepository.save(playlist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/playlist";
    }

    // Hiển thị form sửa playlist
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
        if (playlist.isPresent()) {
            model.addAttribute("playlist", playlist.get());
            model.addAttribute("musics", musicRepository.findAll());
            return "playlist_form";
        }
        return "redirect:/playlist";
    }

    // Xử lý sửa playlist
    @PostMapping("/edit/{id}")
    public String editPlaylist(@PathVariable Long id, @ModelAttribute Playlist playlist, @RequestParam("musicIds") List<Long> musicIds) {
        try {
            playlist.setId(id);
            List<Music> musics = musicRepository.findAllById(musicIds);
            playlist.setMusics(musics);
            playlistRepository.save(playlist);
        } catch (Exception e) {
            e.printStackTrace();
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

    // Phát nhạc từ playlist
    @GetMapping("/play/{id}")
    public String playPlaylist(@PathVariable Long id, Model model) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
        if (playlist.isPresent()) {
            playQueue = playlist.get().getMusics();
            currentIndex = 0;
            if (!playQueue.isEmpty()) {
                model.addAttribute("music", playQueue.get(currentIndex));
            }
        }
        return "music_play";
    }

    // Phát bài tiếp theo
    @GetMapping("/play/next")
    public String playNext(Model model) {
        if (!playQueue.isEmpty()) {
            currentIndex = (currentIndex + 1) % playQueue.size();
            model.addAttribute("music", playQueue.get(currentIndex));
        }
        return "music_play";
    }

    // Phát ngẫu nhiên
    @GetMapping("/play/shuffle")
    public String playShuffle(Model model) {
        if (!playQueue.isEmpty()) {
            Random random = new Random();
            currentIndex = random.nextInt(playQueue.size());
            model.addAttribute("music", playQueue.get(currentIndex));
        }
        return "music_play";
    }
}
