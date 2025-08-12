package com.kh.spring01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	@RequestMapping("/")
	public String home() 
	{
		return "Welcome to Spring Boot";
	}
}