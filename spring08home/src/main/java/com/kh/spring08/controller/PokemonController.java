package com.kh.spring08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring08.dao.PokemonDao;
import com.kh.spring08.dto.PokemonDto;

@Controller
@RequestMapping("/pokemon")
public class PokemonController 
{
	@Autowired
	private PokemonDao pokemonDao;
	
	@RequestMapping("/add1")
	public String add1() 
	{
		return "/WEB-INF/views/pokemon/add1.jsp";
	}
	
	@RequestMapping("/add2")
	public String add2(@ModelAttribute PokemonDto pokemonDto) 
	{
		pokemonDao.insert(pokemonDto);
		//return "/WEB-INF/views/pokemon/add2.jsp";
		return "redirect:add3";
	}
	
	@RequestMapping("/add3")
	public String add3() 
	{
		return "/WEB-INF/views/pokemon/add3.jsp";
	}
//	@RequestMapping("/add2")
//	@RequestMapping("/add3")
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 객체를 달라고 하면 객체 내부의 필드값을 달라는 소리로 해석된다
	@RequestMapping("/add")
	public String add(@ModelAttribute PokemonDto pokemonDto) 
	{
		pokemonDao.insert(pokemonDto);
		return "포켓몬 등록 완료";
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute PokemonDto pokemonDto) 
	{
		boolean success = pokemonDao.update(pokemonDto);
		if (success)
			return "포켓몬 수정 완료";
		else
			return "존재하지 않는 포켓몬입니다.";
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam int pokemonNo) 
	{
		boolean success = pokemonDao.delete(pokemonNo);
		if (success)
			return "포켓몬 삭제 완료";
		else
			return "존재하지 않는 포켓몬입니다.";
	}
	
	@RequestMapping("/list")
	public String select(@RequestParam(required = false) String column, 
			@RequestParam(required = false) String keyword) 
	{
		List<PokemonDto> list = null;
		if (column == null || keyword == null)
			list = pokemonDao.selectList();
		else
			list = pokemonDao.selectList(column, keyword);
			
		StringBuffer buffer = new StringBuffer();
	
		buffer.append("포켓몬 수 : " + list.size() + "<br>");
		for(PokemonDto solo : list)
		{
			buffer.append(solo);
			buffer.append("<br>");			
		}
		
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int pokemon_no) 
	{
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemon_no);
		if (pokemonDto == null)
			return "존재하지 않는 포켓몬입니다.";
			
		StringBuffer buffer = new StringBuffer();
	
		buffer.append("포켓몬 : " + pokemonDto.getPokemonName() + "<br>");
		buffer.append("<br>");
		buffer.append(pokemonDto);
		buffer.append("<br>");
		
		return buffer.toString();
	}
}