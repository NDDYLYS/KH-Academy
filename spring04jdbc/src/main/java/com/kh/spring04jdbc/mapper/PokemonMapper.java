package com.kh.spring04jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring04jdbc.dto.PokemonDto;


@Component
public class PokemonMapper implements RowMapper<PokemonDto>
{
	@Override
	public PokemonDto mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		PokemonDto pokemonDto = new PokemonDto();
		
		pokemonDto.setPokemonNo(rs.getInt("pokemon_no"));
		pokemonDto.setPokemonName(rs.getString("pokemon_name"));
		pokemonDto.setPokemonType(rs.getString("pokemon_type"));
		
		// TODO Auto-generated method stub
		return pokemonDto;
	}
}