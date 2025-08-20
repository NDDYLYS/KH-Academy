package com.kh.spring09home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/total")
public class TotalController 
{
	@RequestMapping("/country")
	public String country() 
	{
		return "/WEB-INF/views/total/country.jsp";
	}
	
	@RequestMapping("/medalist")
	public String medalist() 
	{
		return "/WEB-INF/views/total/medalist.jsp";
	}
	
	@RequestMapping("/item")
	public String item() 
	{
		return "/WEB-INF/views/total/item.jsp";
	}
	
	@RequestMapping("/handphone")
	public String handphone() 
	{
		return "/WEB-INF/views/total/handphone.jsp";
	}
}
