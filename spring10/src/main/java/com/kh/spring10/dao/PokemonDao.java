package com.kh.spring10.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.kh.spring10.dto.PokemonDto;

@Repository
public class PokemonDao 
{
	@Autowired
	private SqlSession sqlSession;
	
	
	public int sequence() 
	{
		return sqlSession.selectOne("pokemon.sequence");
	}
	
	public void insert(PokemonDto pokemonDto) 
	{
		sqlSession.insert("pokemon.insert", pokemonDto);
	}
}