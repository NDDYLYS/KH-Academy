package com.kh.spring09home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09home.dao.PokemonDao;
import com.kh.spring09home.dto.PokemonDto;
import com.kh.spring09home.error.TargetNotfoundException;

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
	
	// 목록 페이지 매핑
	@RequestMapping("/list")
	public String list(Model model, 
			@RequestParam(required = false) String column, 
			@RequestParam(required = false) String keyword) 
	{
		boolean isSearch = column != null && keyword != null;
		if (isSearch) 
		{
			List<PokemonDto> pokemonList = pokemonDao.selectList(column, keyword);
			model.addAttribute("pokemonList", pokemonList);
		}
		else 
		{
			List<PokemonDto> pokemonList = pokemonDao.selectList();
			model.addAttribute("pokemonList", pokemonList);
		}
		return "/WEB-INF/views/pokemon/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model,
			@RequestParam int pokemonNo) 
	{
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		model.addAttribute("pokemonDto", pokemonDto);
		
		return "/WEB-INF/views/pokemon/detail.jsp";
	}
	
	@GetMapping("/edit")
	public String edit(Model model,
			@RequestParam int pokemonNo)
	{
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		if (pokemonDto == null) 
		{
			//return "redirect:list"; // 에러페이지매핑
			//throw new RuntimeException("존재하지 않는 포켓몬 번호");
			throw new TargetNotfoundException("존재하지 않는 포켓몬 번호");
		}
		
		model.addAttribute("pokemonDto", pokemonDto);
		return "/WEB-INF/views/pokemon/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute PokemonDto pokemonDto) 
	{
		pokemonDao.update(pokemonDto);
		return "redirect:detail?pokemonNo=" + pokemonDto.getPokemonNo();
	}
}