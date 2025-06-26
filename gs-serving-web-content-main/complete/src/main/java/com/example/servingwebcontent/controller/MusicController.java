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
        return "music_form";
    }

    // Xử lý thêm mới
    @PostMapping("/add")
    public String addMusic(@ModelAttribute Music music) {
        try {
            musicRepository.save(music);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/music";
    }

    // Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Music> music = musicRepository.findById(id);
        if (music.isPresent()) {
            model.addAttribute("music", music.get());
            return "music_form";
        }
        return "redirect:/music";
    }

    // Xử lý sửa
    @PostMapping("/edit/{id}")
    public String editMusic(@PathVariable Long id, @ModelAttribute Music music) {
        try {
            music.setId(id);
            musicRepository.save(music);
        } catch (Exception e) {
            e.printStackTrace();
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
