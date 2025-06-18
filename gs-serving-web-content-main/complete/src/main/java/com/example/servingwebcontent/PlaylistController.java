package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PlaylistController {

    @GetMapping("/playlists")
    public String showPlaylists(Model model) {
        List<Playlist> playlists = new ArrayList<>();
        playlists.add(new Playlist("Chill Hits", "PL001", 10, 3200));
        playlists.add(new Playlist("Kpop Vibes", "PL002", 8, 2500));
        playlists.add(new Playlist("US-UK Top", "PL003", 12, 4000));
        model.addAttribute("playlists", playlists);
        return "playlistView";
    }
}
