package com.kh.spring10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "/WEB-INF/views/home.jsp";
    }
    @GetMapping("/event")
    public String event() {
        return "/WEB-INF/views/event.jsp";
    }
    @PostMapping("/event")
    public String event(@RequestParam String name) {
        //처리 코드 생략
        return "redirect:/";
    }
}