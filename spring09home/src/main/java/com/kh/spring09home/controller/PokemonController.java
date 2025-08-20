package com.kh.spring09home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09home.dao.PokemonDao;
import com.kh.spring09home.dto.PokemonDto;

@Controller
@RequestMapping("/pokemon")
public class PokemonController 
{
	@Autowired
	private PokemonDao pokemonDao;
	
	@GetMapping("/add")
	public String add() 
	{
		return "/WEB-INF/views/pokemon/add.jsp";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute PokemonDto pokemonDto) 
	{
		pokemonDao.insert(pokemonDto);
		//return "/WEB-INF/views/pokemon/add2.jsp";
		return "redirect:addFinish";
	}
	
	@RequestMapping("/addFinish")
	public String addFinish() 
	{
		return "/WEB-INF/views/pokemon/addFinish.jsp";
	}
}