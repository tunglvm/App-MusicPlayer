package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserRepository userRepository = new UserRepository();

    @GetMapping("/user")
    public String getUserPage(Model model) {
        List<User> users = userRepository.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/user")
    public String addUser(@RequestParam String username,
                          @RequestParam String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        userRepository.addUser(user);
        return "redirect:/user";
    }

    @PostMapping("/user/update")
    public String updateUser(@RequestParam long id,
                             @RequestParam String username,
                             @RequestParam String email) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        userRepository.updateUser(user);
        return "redirect:/user";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepository.deleteUser(id);
        return "redirect:/user";
    }
}