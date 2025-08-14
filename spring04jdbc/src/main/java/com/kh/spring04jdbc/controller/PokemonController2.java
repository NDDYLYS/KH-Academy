package com.kh.spring04jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring04jdbc.dao.PokemonDao;
import com.kh.spring04jdbc.dto.PokemonDto;
import com.kh.spring04jdbc.dto.StudentDto;

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