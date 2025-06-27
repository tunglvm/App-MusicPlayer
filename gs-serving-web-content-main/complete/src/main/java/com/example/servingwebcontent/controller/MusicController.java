package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Album;
import com.example.servingwebcontent.model.Music;
import com.example.servingwebcontent.model.Playlist;
import com.example.servingwebcontent.repository.AlbumRepository;
import com.example.servingwebcontent.repository.MusicRepository;
import com.example.servingwebcontent.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    // Danh sách bài hát
    @GetMapping
    public String listMusic(Model model) {
        model.addAttribute("musics", musicRepository.findAll());
        return "music";
    }

    // Hiển thị form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("music", new Music());
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("playlists", playlistRepository.findAll());
        return "music_form";
    }

    // Xử lý thêm mới
    @PostMapping("/add")
    public String addMusic(@ModelAttribute Music music,
                           @RequestParam(value = "albumId", required = false) Long albumId,
                           @RequestParam(value = "playlistIds", required = false) List<Long> playlistIds) {
        // Liên kết album
        if (albumId != null) {
            albumRepository.findById(albumId).ifPresent(music::setAlbum);
        }

        // Liên kết playlists
        if (playlistIds != null && !playlistIds.isEmpty()) {
            List<Playlist> playlists = playlistRepository.findAllById(playlistIds);
            music.setPlaylists(playlists);
        } else {
            music.setPlaylists(new ArrayList<>());
        }

        musicRepository.save(music);
        return "redirect:/music";
    }

    // Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Music> music = musicRepository.findById(id);
        if (music.isPresent()) {
            model.addAttribute("music", music.get());
            model.addAttribute("albums", albumRepository.findAll());
            model.addAttribute("playlists", playlistRepository.findAll());
            return "music_form";
        }
        return "redirect:/music";
    }

    // Xử lý sửa
    @PostMapping("/edit/{id}")
    public String editMusic(@PathVariable Long id,
                            @ModelAttribute Music music,
                            @RequestParam(value = "albumId", required = false) Long albumId,
                            @RequestParam(value = "playlistIds", required = false) List<Long> playlistIds) {
        Optional<Music> musicOpt = musicRepository.findById(id);
        if (musicOpt.isPresent()) {
            Music existing = musicOpt.get();
            existing.setTitle(music.getTitle());
            existing.setArtist(music.getArtist());
            existing.setUrl(music.getUrl());
            existing.setCover(music.getCover());

            // Cập nhật album
            if (albumId != null) {
                albumRepository.findById(albumId).ifPresent(existing::setAlbum);
            } else {
                existing.setAlbum(null);
            }

            // Cập nhật playlists
            if (playlistIds != null && !playlistIds.isEmpty()) {
                List<Playlist> playlists = playlistRepository.findAllById(playlistIds);
                existing.setPlaylists(playlists);
            } else {
                existing.setPlaylists(new ArrayList<>());
            }

            musicRepository.save(existing);
        }
        return "redirect:/music";
    }

    // Xử lý xóa
    @GetMapping("/delete/{id}")
    public String deleteMusic(@PathVariable Long id) {
        try {
            musicRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/music";
    }

    // Phát nhạc
    @GetMapping("/play/{id}")
    public String playMusic(@PathVariable Long id, Model model) {
        Optional<Music> music = musicRepository.findById(id);
        if (music.isPresent()) {
            model.addAttribute("music", music.get());
        } else {
            model.addAttribute("error", "Bài hát không tồn tại!");
        }
        return "music_play";
    }
}
