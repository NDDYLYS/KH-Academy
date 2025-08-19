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
	
	@RequestMapping("/test01")
	public String test01() 
	{
		return "/WEB-INF/views/test01.jsp";
	}
	
	@RequestMapping("/test02")
	public String test02() 
	{
		return "/WEB-INF/views/test02.jsp";
	}
	
	@RequestMapping("/test03")
	public String test03() 
	{
		return "/WEB-INF/views/test03.jsp";
	}
}