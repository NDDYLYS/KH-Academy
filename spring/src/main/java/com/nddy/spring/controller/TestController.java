package com.nddy.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nddy.spring.dao.TestDao;
import com.nddy.spring.dto.TestDto;

@RestController
@RequestMapping("/pokemon")
public class TestController 
{
	@Autowired
	private TestDao pokemonDao;
	
	// 객체를 달라고 하면 객체 내부의 필드값을 달라는 소리로 해석된다
	@RequestMapping("/add")
	public String add(@ModelAttribute TestDto pokemonDto) 
	{
		pokemonDao.insert(pokemonDto);
		return "포켓몬 등록 완료";
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam(required = false, defaultValue = "") String column, 
			@RequestParam(required = false, defaultValue = "") String keyword) 
	{
		List<TestDto> list = null;
		if (column.equals("") || keyword.equals(""))
			list = pokemonDao.selectList();
		else
			list = pokemonDao.selectSearch(column, keyword);
		
		StringBuffer buffer = new StringBuffer();		
		buffer.append("서적 수 : " + list.size() + "<br>");
		for(TestDto solo : list)
		{
			buffer.append(solo);
			buffer.append("<br>");			
		}
		
		return buffer.toString();
	}
}