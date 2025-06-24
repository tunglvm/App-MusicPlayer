package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Song;
import com.example.servingwebcontent.repository.MusicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MusicController {

    private final MusicRepository musicRepository;

    public MusicController(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @GetMapping("/music")
    public String getMusicPage(@RequestParam(required = false) String sort, Model model) {
        try {
            List<Song> songs = musicRepository.getAllSongs();
            if ("title".equalsIgnoreCase(sort)) {
                songs.sort(Comparator.comparing(Song::getTitle, String.CASE_INSENSITIVE_ORDER));
            }
            model.addAttribute("songs", songs);
            model.addAttribute("song", new Song());
            return "music";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tải danh sách bài hát: " + e.getMessage());
            return "music";
        }
    }

    @PostMapping("/music/add")
    public String addSong(@RequestParam String title,
                          @RequestParam String artist,
                          @RequestParam int duration,
                          @RequestParam(required = false) String url,
                          @RequestParam(required = false) String coverUrl,
                          Model model) {
        try {
            Song song = new Song();
            song.setTitle(title);
            song.setArtist(artist);
            song.setDuration(duration);
            song.setUrl(url);
            song.setCoverUrl(coverUrl);
            musicRepository.addSong(song);
        } catch (Exception e) {
            model.addAttribute("error", "Không thể thêm bài hát: " + e.getMessage());
        }
        return "redirect:/music";
    }

    @PostMapping("/music/update")
    public String updateSong(@RequestParam long id,
                             @RequestParam String title,
                             @RequestParam String artist,
                             @RequestParam int duration,
                             @RequestParam(required = false) String url,
                             @RequestParam(required = false) String coverUrl,
                             Model model) {
        try {
            Optional<Song> existingSong = musicRepository.getSongById(id);
            if (existingSong.isPresent()) {
                Song song = existingSong.get();
                song.setTitle(title);
                song.setArtist(artist);
                song.setDuration(duration);
                song.setUrl(url);
                song.setCoverUrl(coverUrl);
                musicRepository.updateSong(song);
            }
        } catch (Exception e) {
            model.addAttribute("error", "Không thể cập nhật bài hát: " + e.getMessage());
        }
        return "redirect:/music";
    }

    @GetMapping("/music/delete/{id}")
    public String deleteSong(@PathVariable long id) {
        try {
            musicRepository.deleteSong(id);
        } catch (Exception e) {
            // Có thể log lỗi nếu muốn
        }
        return "redirect:/music";
    }

    @GetMapping("/music/clear")
    public String clearSongs() {
        try {
            musicRepository.clearAllSongs();
        } catch (Exception e) {
            // Có thể log lỗi nếu muốn
        }
        return "redirect:/music";
    }

    @GetMapping("/music/search")
    public String searchSongs(@RequestParam String query, Model model) {
        try {
            List<Song> filteredSongs = musicRepository.getAllSongs().stream()
                    .filter(song -> song.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                            song.getArtist().toLowerCase().contains(query.toLowerCase()))
                    .toList();
            model.addAttribute("songs", filteredSongs);
            model.addAttribute("query", query);
            model.addAttribute("song", new Song());
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tìm kiếm bài hát: " + e.getMessage());
        }
        return "music";
    }
}
