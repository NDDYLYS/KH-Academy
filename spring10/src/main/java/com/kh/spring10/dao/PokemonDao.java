package com.kh.spring10.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public PokemonDto selectOne(int pokemonNo) 
	{
		return sqlSession.selectOne("pokemon.detail", pokemonNo);
	}
	
	public boolean delete(int pokemonNo) 
	{
		return sqlSession.delete("pokemon.delete", pokemonNo) > 0;
	}
	
	public boolean update(PokemonDto pokemonDto) 
	{
		return sqlSession.update("pokemon.update", pokemonDto) > 0;
	}
	
	public boolean updateUnit(PokemonDto pokemonDto) 
	{
		return sqlSession.update("pokemon.updateUnit", pokemonDto) > 0;
	}
	
	public List<PokemonDto> selectList(int page) {
		//필요한 값 계산
		int size = 10;
		int begin = page * size - (size - 1);
		int end = page * size;
		
		Map<String, Integer> params = new HashMap<>();
		params.put("begin", begin);
		params.put("end", end);
		
		return sqlSession.selectList("pokemon.listByPaging", params);
	}
}