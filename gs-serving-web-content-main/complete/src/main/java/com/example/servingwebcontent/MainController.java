package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "redirect:/index.html"; // file tĩnh
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // trả về file home.html trong templates
    }

    // Đã bỏ các mapping /music, /playlist, /album để tránh trùng với các controller chuyên biệt
}
