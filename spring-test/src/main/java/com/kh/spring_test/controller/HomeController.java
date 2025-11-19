package com.kh.spring_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
    public String home() {
        return "/WEB-INF/views/home.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "/WEB-INF/views/login.jsp";
    }
//    @PostMapping("/login")
//    public String login(@ModelAttribute MemberDto memberDto) {
//        //로그인 코드 생략
//        return "redirect:http://localhost:8080/";
//    }
//    
//    @RequestMapping("/aaa")
//    public String aaa() {
//        return "WEB-INF/views/aaa.jsp";
//    }
}