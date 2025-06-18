// MusicController.java
package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MusicController {

    
    private MusicLibrary musicLibrary;

    public MusicController() {
        // Thêm một số bài hát mẫu vào thư viện
        musicLibrary.addSong(new Song("Song 1", "Artist A"));
        musicLibrary.addSong(new Song("Song 2", "Artist B"));
        musicLibrary.addSong(new Song("Song 3", "Artist A"));
    }

    @GetMapping("/songs")
    public String displaySongsByArtist(@RequestParam String artistName, Model model) {
        model.addAttribute("artistName", artistName);
        model.addAttribute("songs", musicLibrary.displaySongsByArtist(artistName));
        return "songs";
    }
}
