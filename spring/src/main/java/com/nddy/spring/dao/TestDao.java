package com.nddy.spring.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nddy.spring.dto.TestDto;
import com.nddy.spring.mapper.TestMapper;

@Repository
public class TestDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private TestMapper pokemonMapper;
	
	public void insert(TestDto pokemonDto) 
	{
		String sql = "insert into pokemon (pokemon_no, pokemon_name, pokemon_type) "
				+ "values (pokemon_seq.nextval, ?, ?)";
		Object[] params = {pokemonDto.getPokemonName(),
				pokemonDto.getPokemonType()};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(TestDto pokemonDto) 
	{
		String sql = "update pokemon set pokemon_name=?, pokemon_type=? "
    			+ "where pokemon_no=?";
    	Object[] params = {pokemonDto.getPokemonName(), pokemonDto.getPokemonType(), pokemonDto.getPokemonNo()};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	} 
	
	public boolean delete(int pokemonNo) 
	{
		String sql = "delete pokemon where pokemon_no=?";
    	Object[] params = {pokemonNo};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<TestDto> selectSearch(String column, String keyword)
	{
		//Set<String> allowList = Set.of("book_title", "book_author");
		
		//if (allowList.contains(column) == false)
		//	return List.of(); // 비어있는 리스트;	
		
		String sql = "select * from pokemon where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, pokemon_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, pokemonMapper, params);
	}
	
	public List<TestDto> selectList()
	{
		String sql = "select * from pokemon order by pokemon_no asc";
    	return jdbcTemplate.query(sql, pokemonMapper);
	}
	
	public TestDto selectOne(int bookId) 
	{
		String sql = "select * from pokemon where pokemon_no = ?";
		Object[] params = {bookId};
		List<TestDto> list = jdbcTemplate.query(sql, pokemonMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
}