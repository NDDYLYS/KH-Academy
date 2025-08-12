package com.kh.spring04jdbc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring04jdbc.dto.PokemonDto;
import com.kh.spring04jdbc.mapper.PokemonMapper;

@Repository
public class PokemonDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PokemonMapper pokemonMapper;
	
	public void insert(PokemonDto pokemonDto) 
	{
		String sql = "insert into pokemon (pokemon_no, pokemon_name, pokemon_type) "
				+ "values (pokemon_seq.nextval, ?, ?)";
		Object[] params = {pokemonDto.getPokemonName(),
				pokemonDto.getPokemonType()};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(PokemonDto pokemonDto) 
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
	
	public List<PokemonDto> selectList(String column, String keyword)
	{
    	Set<String> allowList = Set.of("pokemon_name", "pokemon_type");
		
		if (allowList.contains(column) == false)
			return List.of(); // 비어있는 리스트;		
		
		String sql = "select * from pookemon where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, pokemon_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, pokemonMapper, params);
	}
	
	public PokemonDto selectOne(int pokemonNo) 
	{
		String sql = "select * from pokemon where pokemon_no = ?";
    	Object[] params = {pokemonNo};
    	// sql, params, mapper를 쓰면 List가 나온다
    	// ResultSetExtractor / PokemonDto
    	List<PokemonDto> list = jdbcTemplate.query(sql, pokemonMapper, params);
    	
    	return list.isEmpty() ? null : list.get(0);
	}
}