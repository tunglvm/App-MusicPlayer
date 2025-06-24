package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Music;
import com.example.servingwebcontent.repository.MusicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
// Xóa dòng này, vì @GetMapping đã được import đúng ở trên từ org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/music")
public class MusicController {
    private final MusicRepository musicRepository;

    public MusicController(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @GetMapping
    public String showMusicList(Model model) {
        model.addAttribute("musicList", musicRepository.findAll());
        model.addAttribute("music", new Music());
        return "music";
    }

    @PostMapping("/add")
    public String addMusic(@ModelAttribute Music music, Model model) {
        try {
            musicRepository.save(music);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi thêm bài hát.");
        }
        return "redirect:/music";
    }

    @GetMapping("/delete/{id}")
    public String deleteMusic(@PathVariable Long id) {
        try {
            musicRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa bài hát: " + e.getMessage());
        }
        return "redirect:/music";
    }

    @GetMapping("/edit/{id}")
    public String editMusic(@PathVariable Long id, Model model) {
        Music music = musicRepository.findById(id).orElse(null);
        model.addAttribute("music", music);
        model.addAttribute("musicList", musicRepository.findAll());
        return "music";
    }

    @GetMapping("/play/{id}")
    public String playMusic(@PathVariable Long id, Model model) {
        Music music = musicRepository.findById(id).orElse(null);
        model.addAttribute("playing", music);
        model.addAttribute("musicList", musicRepository.findAll());
        model.addAttribute("music", new Music());
        return "music";
    }
}
