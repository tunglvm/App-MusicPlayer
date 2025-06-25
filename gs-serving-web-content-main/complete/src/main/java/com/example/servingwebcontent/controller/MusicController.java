package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Music;
import com.example.servingwebcontent.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;

    @GetMapping
    public String listMusic(Model model) {
        model.addAttribute("musics", musicRepository.findAll());
        return "music";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("music", new Music());
        return "music_form";
    }

    @PostMapping("/add")
    public String addMusic(@ModelAttribute Music music) {
        musicRepository.save(music);
        return "redirect:/music";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Music> music = musicRepository.findById(id);
        if (music.isPresent()) {
            model.addAttribute("music", music.get());
            return "music_form";
        }
        return "redirect:/music";
    }

    @PostMapping("/edit/{id}")
    public String editMusic(@PathVariable Long id, @ModelAttribute Music music) {
        music.setId(id);
        musicRepository.save(music);
        return "redirect:/music";
    }

    @GetMapping("/delete/{id}")
    public String deleteMusic(@PathVariable Long id) {
        musicRepository.deleteById(id);
        return "redirect:/music";
    }

    @GetMapping("/play/{id}")
    public String playMusic(@PathVariable Long id, Model model) {
        Optional<Music> music = musicRepository.findById(id);
        if (music.isPresent()) {
            model.addAttribute("music", music.get());
            return "music_play";
        }
        model.addAttribute("error", "Bài hát không tồn tại!");
        return "music_play";
    }
}