package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Player;
import com.example.servingwebcontent.repository.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlayerController {
    private final PlayerRepository playerRepository = new PlayerRepository();

    @GetMapping("/player")
    public String getPlayerPage(Model model) {
        List<Player> players = playerRepository.getAllPlayers();
        model.addAttribute("players", players);
        model.addAttribute("player", new Player());
        return "player";
    }

    @PostMapping("/player")
    public String addPlayer(@RequestParam String name) {
        Player player = new Player();
        player.setName(name);
        playerRepository.addPlayer(player);
        return "redirect:/player";
    }

    @PostMapping("/player/update")
    public String updatePlayer(@RequestParam int id, @RequestParam String name) {
        Player player = new Player();
        player.setId(id);
        player.setName(name);
        playerRepository.updatePlayer(player);
        return "redirect:/player";
    }

    @GetMapping("/player/delete/{id}")
    public String deletePlayer(@PathVariable int id) {
        playerRepository.deletePlayer(id);
        return "redirect:/player";
    }
}