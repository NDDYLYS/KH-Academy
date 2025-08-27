package com.kh.spring09home.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kh.spring09home.mapper.StatMapper;
import com.kh.spring09home.vo.StatVO;

public class StatDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private StatMapper statMapper;
	
	public List<StatVO> countBypokemonType()
	{
		String sql = "select pokemon_type title, count(*) value from "
				+ "pokemon group by pokemon_type "
				+ "order by value desc, title asc";
		return jdbcTemplate.query(sql, statMapper);
	}
}
