package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Album;
import com.example.servingwebcontent.repository.AlbumRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlbumController {
    private final AlbumRepository albumRepository = new AlbumRepository();

    @GetMapping("/album")
    public String getAlbumPage(Model model) {
        try {
            List<Album> albums = albumRepository.getAllAlbums();
            model.addAttribute("albums", albums);
            model.addAttribute("album", new Album());
            return "album";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi tải danh sách album!");
            return "error";
        }
    }

    @PostMapping("/album")
    public String addAlbum(@RequestParam String name, Model model) {
        try {
            Album album = new Album();
            album.setName(name);
            albumRepository.addAlbum(album);
            return "redirect:/album";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi thêm album!");
            return "error";
        }
    }

    @PostMapping("/album/update")
    public String updateAlbum(@RequestParam int id, @RequestParam String name, Model model) {
        try {
            Album album = new Album();
            album.setId(id);
            album.setName(name);
            albumRepository.updateAlbum(album);
            return "redirect:/album";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi cập nhật album!");
            return "error";
        }
    }

    @GetMapping("/album/delete/{id}")
    public String deleteAlbum(@PathVariable int id, Model model) {
        try {
            albumRepository.deleteAlbum(id);
            return "redirect:/album";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi xóa album!");
            return "error";
        }
    }
}