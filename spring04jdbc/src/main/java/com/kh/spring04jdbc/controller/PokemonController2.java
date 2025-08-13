package com.kh.spring04jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring04jdbc.dao.PokemonDao;
import com.kh.spring04jdbc.dto.PokemonDto;

@RestController
@RequestMapping("/pokemon")
public class PokemonController2 
{
	@Autowired
	private PokemonDao pokemonDao;
	
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
		pokemonDao.update(pokemonDto);
		return "포켓몬 수정 완료";
	}
}