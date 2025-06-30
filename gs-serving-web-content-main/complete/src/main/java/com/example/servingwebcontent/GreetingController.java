package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(
        @RequestParam(name="name", required=false, defaultValue="everyone") String name,
        Model model
    ) {
        model.addAttribute("name", name);
        model.addAttribute("totalSongs", 50); // ví dụ, bạn có thể lấy số thực tế từ DB
        return "greeting";
    }
}
