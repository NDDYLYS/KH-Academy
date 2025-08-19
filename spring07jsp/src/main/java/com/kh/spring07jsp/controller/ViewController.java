package com.kh.spring07jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController 
{
	@RequestMapping("/hello")
	public String hello()
	{
		return "/WEB-INF/views/hello.jsp";
	}
}