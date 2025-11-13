package com.kh.spring10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<PokemonDto> selectList()
	{
		return sqlSession.selectList("pokemon.list");
	}
}