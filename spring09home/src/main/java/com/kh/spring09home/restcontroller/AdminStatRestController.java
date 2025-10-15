package com.kh.spring09home.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09home.dao.StatDao;
import com.kh.spring09home.vo.ChartVO;
import com.kh.spring09home.vo.StatVO;

@CrossOrigin
@RestController
@RequestMapping("/rest/admin/stat")
public class AdminStatRestController 
{
	@Autowired
	private StatDao statDao;
	
	@PostMapping("/pokemon")
	public List<StatVO> pokemon() 
	{
		return statDao.countBypokemonType();
	}	
	
	@PostMapping("/student")
	public List<StatVO> student() 
	{
		return statDao.countByStudentDaily();
	}
	
	@PostMapping("/book")
	public List<StatVO> book() 
	{
		return statDao.countByBookGenre();
	}
	
	@PostMapping("/member")
	public List<StatVO> member() 
	{
		return statDao.countByMemberLevel();
	}
	
	@PostMapping("/pokemon2")
	public ChartVO pokemon2() 
	{
		List<StatVO> list = statDao.countBypokemonType();
		List<String> labels = new ArrayList<>();
		List<Double> data = new ArrayList<>();
		
		for(StatVO statVO : list) 
		{
			labels.add(statVO.getTitle());
			data.add(statVO.getValue());
		}
		
		return ChartVO.builder().subject("포켓몬").type("bar").labels(labels).data(data).build();
	}	
}
