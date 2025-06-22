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
        List<Album> albums = albumRepository.getAllAlbums();
        model.addAttribute("albums", albums);
        model.addAttribute("album", new Album());
        return "album";
    }

    @PostMapping("/album")
    public String addAlbum(@RequestParam String name) {
        Album album = new Album();
        album.setName(name);
        albumRepository.addAlbum(album);
        return "redirect:/album";
    }

    @PostMapping("/album/update")
    public String updateAlbum(@RequestParam int id, @RequestParam String name) {
        Album album = new Album();
        album.setId(id);
        album.setName(name);
        albumRepository.updateAlbum(album);
        return "redirect:/album";
    }

    @GetMapping("/album/delete/{id}")
    public String deleteAlbum(@PathVariable int id) {
        albumRepository.deleteAlbum(id);
        return "redirect:/album";
    }
}