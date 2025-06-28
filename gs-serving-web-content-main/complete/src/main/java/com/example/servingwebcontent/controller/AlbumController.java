package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Album;
import com.example.servingwebcontent.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    // Danh sách album
    @GetMapping
    public String listAlbums(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "album";
    }

    // Hiển thị form thêm album mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("album", new Album());
        return "album_form";
    }

    // Xử lý thêm album
    @PostMapping("/add")
    public String addAlbum(@ModelAttribute Album album) {
        try {
            albumRepository.save(album);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/album";
    }

    // Hiển thị form sửa album
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Album> album = albumRepository.findById(id);
        if (album.isPresent()) {
            model.addAttribute("album", album.get());
            return "album_form";
        }
        return "redirect:/album";
    }

    // Xử lý sửa album
    @PostMapping("/edit/{id}")
    public String editAlbum(@PathVariable Long id, @ModelAttribute Album album) {
        try {
            album.setId(id);
            albumRepository.save(album);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/album";
    }

    // Xử lý xóa album
    @GetMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable Long id) {
        try {
            albumRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/album";
    }

    // Hiển thị danh sách bài hát trong album
    @GetMapping("/{id}/musics")
    public String showSongsInAlbum(@PathVariable Long id, Model model) {
        Optional<Album> albumOpt = albumRepository.findById(id);
        if (albumOpt.isPresent()) {
            Album album = albumOpt.get();
            model.addAttribute("album", album);
            model.addAttribute("musics", album.getMusics());
            return "album_musics"; // Tạo view album_songs.html để hiển thị danh sách bài hát
        }
        return "redirect:/album";
    }

    // Phát toàn bộ album (giả lập)
    @GetMapping("/{id}/play")
    @ResponseBody
    public String playAllSongs(@PathVariable Long id) {
        Optional<Album> albumOpt = albumRepository.findById(id);
        if (albumOpt.isPresent()) {
            Album album = albumOpt.get();
            return "Đang phát toàn bộ album: " + album.getName();
        }
        return "Album không tồn tại!";
    }

    // Phát một bài hát cụ thể trong album (giả lập)
    @GetMapping("/{albumId}/songs/{songIndex}/play")
    @ResponseBody
    public String playSongInAlbum(@PathVariable Long albumId, @PathVariable int songIndex) {
        Optional<Album> albumOpt = albumRepository.findById(albumId);
        if (albumOpt.isPresent()) {
            Album album = albumOpt.get();
            if (album.getMusics() != null && songIndex >= 0 && songIndex < album.getMusics().size()) {
                return "Đang phát: " + album.getMusics().get(songIndex).getTitle();
            }
            return "Bài hát không tồn tại!";
        }
        return "Album không tồn tại!";
    }

    // Phát ngẫu nhiên một bài hát trong album (giả lập)
    @GetMapping("/{id}/random/play")
    @ResponseBody
    public String playRandomSong(@PathVariable Long id) {
        Optional<Album> albumOpt = albumRepository.findById(id);
        if (albumOpt.isPresent()) {
            Album album = albumOpt.get();
            if (album.getMusics() == null || album.getMusics().isEmpty()) return "Album không có bài hát!";
            int idx = new java.util.Random().nextInt(album.getMusics().size());
            return "Đang phát ngẫu nhiên: " + album.getMusics().get(idx).getTitle();
        }
        return "Album không tồn tại!";
    }
}
