package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.PokemonDto;


public class PokemonMapper implements RowMapper<PokemonDto>
{

	@Override
	public PokemonDto mapRow(ResultSet rs, int idx) throws SQLException 
	{
		PokemonDto pokemonDto = new PokemonDto();
		// 조회 결과에 있는 pokemon_no라는 칸의 데이터를 int 형태로 꺼내서 DTO에 저장하세요
		pokemonDto.setPokemonNo(rs.getInt("pokemon_no"));
		// 조회 결과에 있는 pokemon_name라는 칸의 데이터를 String 형태로 꺼내서 DTO에 저장하세요
		pokemonDto.setPokemonName(rs.getString("pokemon_name"));
		// 조회 결과에 있는 pokemon_type라는 칸의 데이터를 String 형태로 꺼내서 DTO에 저장하세요
		pokemonDto.setPokemonType(rs.getString("pokemon_type"));
		
		// TODO Auto-generated method stub
		
		// ResultSet에 담긴 데이터를 PokemonDto로 변환하여 반환하는 코드
		return pokemonDto;
	}
}