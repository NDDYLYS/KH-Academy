package com.nddy.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.nddy.spring.dto.TestDto;

@Component
public class TestMapper implements RowMapper<TestDto>
{
	@Override
	public TestDto mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		TestDto pokemonDto = new TestDto();
		
		pokemonDto.setPokemonNo(rs.getInt("pokemon_no"));
		pokemonDto.setPokemonName(rs.getString("pokemon_name"));
		pokemonDto.setPokemonType(rs.getString("pokemon_type"));
		
		// TODO Auto-generated method stub
		return pokemonDto;
	}
}