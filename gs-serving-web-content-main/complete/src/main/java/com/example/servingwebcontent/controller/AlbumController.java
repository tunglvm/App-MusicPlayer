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

    @GetMapping("")
    public String listAlbums(Model model) {
        try {
            model.addAttribute("albums", albumRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi lấy danh sách album: " + e.getMessage());
        }
        return "album";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("album", new Album());
        return "album_form";
    }

    @PostMapping("/add")
    public String addAlbum(@ModelAttribute Album album, Model model) {
        try {
            albumRepository.save(album);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi thêm album: " + e.getMessage());
            model.addAttribute("album", album);
            return "album_form";
        }
        return "redirect:/album";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            Optional<Album> album = albumRepository.findById(id);
            if (album.isPresent()) {
                model.addAttribute("album", album.get());
                return "album_form";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi tìm album để sửa: " + e.getMessage());
        }
        return "redirect:/album";
    }

    @PostMapping("/edit/{id}")
    public String editAlbum(@PathVariable Long id, @ModelAttribute Album album, Model model) {
        try {
            album.setId(id);
            albumRepository.save(album);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi sửa album: " + e.getMessage());
            model.addAttribute("album", album);
            return "album_form";
        }
        return "redirect:/album";
    }

    @GetMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable Long id) {
        try {
            albumRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/album";
    }

    @GetMapping("/{id}/musics")
    public String showSongsInAlbum(@PathVariable Long id, Model model) {
        try {
            Optional<Album> albumOpt = albumRepository.findById(id);
            if (albumOpt.isPresent()) {
                Album album = albumOpt.get();
                model.addAttribute("album", album);
                model.addAttribute("musics", album.getMusics());
                return "album_musics";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi hiển thị bài hát trong album: " + e.getMessage());
        }
        return "redirect:/album";
    }

    @GetMapping("/{id}/play")
    @ResponseBody
    public String playAllSongs(@PathVariable Long id) {
        try {
            Optional<Album> albumOpt = albumRepository.findById(id);
            if (albumOpt.isPresent()) {
                Album album = albumOpt.get();
                return "Đang phát toàn bộ album: " + album.getName();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi khi phát toàn bộ album: " + e.getMessage();
        }
        return "Album không tồn tại!";
    }

    @GetMapping("/{albumId}/songs/{songIndex}/play")
    @ResponseBody
    public String playSongInAlbum(@PathVariable Long albumId, @PathVariable int songIndex) {
        try {
            Optional<Album> albumOpt = albumRepository.findById(albumId);
            if (albumOpt.isPresent()) {
                Album album = albumOpt.get();
                if (album.getMusics() != null && songIndex >= 0 && songIndex < album.getMusics().size()) {
                    return "Đang phát: " + album.getMusics().get(songIndex).getTitle();
                }
                return "Bài hát không tồn tại!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi khi phát bài hát: " + e.getMessage();
        }
        return "Album không tồn tại!";
    }

    @GetMapping("/{id}/random/play")
    @ResponseBody
    public String playRandomSong(@PathVariable Long id) {
        try {
            Optional<Album> albumOpt = albumRepository.findById(id);
            if (albumOpt.isPresent()) {
                Album album = albumOpt.get();
                if (album.getMusics() == null || album.getMusics().isEmpty()) return "Album không có bài hát!";
                int idx = new java.util.Random().nextInt(album.getMusics().size());
                return "Đang phát ngẫu nhiên: " + album.getMusics().get(idx).getTitle();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi khi phát ngẫu nhiên: " + e.getMessage();
        }
        return "Album không tồn tại!";
    }
}
