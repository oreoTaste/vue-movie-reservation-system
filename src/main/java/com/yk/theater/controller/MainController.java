package com.yk.theater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("test")
    public String main(Model model) {
        model.addAttribute("data", "data");
        System.out.println("test에 입장");
        return "index.html";
    }

}
