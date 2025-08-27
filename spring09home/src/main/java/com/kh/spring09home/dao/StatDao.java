package com.kh.spring09home.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09home.mapper.StatMapper;
import com.kh.spring09home.vo.StatVO;

@Repository
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
	
	public List<StatVO> countByStudentDaily()
	{
		String sql = "select to_char(student_reg, 'YYYY-MM-DD')"
				+ " title, count(*) value from STUDENT group by"
				+ " to_char(student_reg, 'YYYY-MM-DD') order by"
				+ " value desc, title asc";
		return jdbcTemplate.query(sql, statMapper);
	}
	
	public List<StatVO> countByBookGenre()
	{
		String sql = "select book_genre title, count(*) value from "
				+ "book group by book_genre "
				+ "order by value desc, title asc";
		return jdbcTemplate.query(sql, statMapper);
	}
	
	public List<StatVO> countByMemberLevel()
	{
		String sql = "select member_level title, count(*) value from "
				+ "member group by member_level "
				+ "order by value desc, title asc";
		return jdbcTemplate.query(sql, statMapper);
	}
}
