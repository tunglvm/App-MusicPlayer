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
        try {
            List<User> users = userRepository.getAllUsers();
            model.addAttribute("users", users);
            model.addAttribute("user", new User());
            return "user";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi tải danh sách người dùng!");
            return "error";
        }
    }

    @PostMapping("/user")
    public String addUser(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userRepository.addUser(user);
            return "redirect:/user";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi thêm người dùng!");
            return "error";
        }
    }

    @PostMapping("/user/update")
    public String updateUser(@RequestParam int id, @RequestParam String username, @RequestParam String password, Model model) {
        try {
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            userRepository.updateUser(user);
            return "redirect:/user";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi cập nhật người dùng!");
            return "error";
        }
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id, Model model) {
        try {
            userRepository.deleteUser(id);
            return "redirect:/user";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi xóa người dùng!");
            return "error";
        }
    }
}