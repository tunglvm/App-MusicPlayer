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
}
