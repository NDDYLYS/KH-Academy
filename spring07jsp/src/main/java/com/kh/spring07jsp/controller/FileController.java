package com.kh.spring07jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/file")
public class FileController 
{
	@RequestMapping("/test01")
	public String test01() {
		return "/WEB-INF/views/file/test01.jsp";
	}
	
	@GetMapping("/test02")
	public String test02 (@RequestParam String attach) 
	{
		System.out.println("attach : " + attach);
		return "redirect:test01";
	}
	
	@PostMapping("/test03")
	public String test03 (@RequestParam String attach) 
	{
		System.out.println("attach : " + attach);
		return "redirect:test01";
	}
}
