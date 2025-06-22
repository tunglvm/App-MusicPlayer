package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Song;
import com.example.servingwebcontent.repository.MusicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MusicController {
    private final MusicRepository musicRepository;

    public MusicController(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    // SONG
    @GetMapping("/music")
    public String getMusicPage(Model model) {
        try {
            List<Song> songs = musicRepository.getAllSongs();
            model.addAttribute("songs", songs);
            model.addAttribute("song", new Song());
            return "music";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi tải danh sách bài hát!");
            return "error";
        }
    }

    @PostMapping("/music")
    public String addSongFromMusic(@RequestParam String title,
                                   @RequestParam String artist,
                                   @RequestParam int duration,
                                   @RequestParam(required = false) String url,
                                   Model model) {
        try {
            Song song = new Song();
            song.setTitle(title);
            song.setArtist(artist);
            song.setDuration(duration);
            song.setUrl(url);
            musicRepository.addSong(song);
            return "redirect:/music";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi thêm bài hát!");
            return "error";
        }
    }

    @GetMapping("/music/delete/{id}")
    public String deleteSongFromMusic(@PathVariable long id, Model model) {
        try {
            musicRepository.deleteSong(id);
            return "redirect:/music";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi xóa bài hát!");
            return "error";
        }
    }
}