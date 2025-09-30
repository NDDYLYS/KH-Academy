package com.kh.spring09home.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonLikeDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void insert(String memberId, int pokemonNo) 
	{
		String sql = "insert into pokemon_like(member_id, pokemon_no) values(?, ?)";
		Object[] params = {memberId, pokemonNo};
		jdbcTemplate.update(sql, params);		
	}
	
	public boolean check(String memberId, int pokemonNo) 
	{
		if (memberId == null)
			return false;
		String sql = "select count(*) from pokemon_like where member_id=? and pokemon_no=?";
		Object[] params = {memberId, pokemonNo};
		int count = jdbcTemplate.queryForObject(sql, int.class, params);
		return count > 0;
	}
	
	public boolean delete(String memberId, int pokemonNo) 
	{
		String sql = "delete pokemon_like where member_id = ? and pokemon_no = ?";
		Object[] params = {memberId, pokemonNo};
		return jdbcTemplate.update(sql, params) > 0;		
	}
	
	public int countByPokemonNo(int pokemonNo) 
	{
		String sql = "select count(*) from pokemon_like where pokemon_no = ?";
		Object[] params = {pokemonNo};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	
	public int countByMemberId(int memberId) 
	{
		String sql = "select pokemon_no from pokemon_like where member_id = ?";
		Object[] params = {memberId};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
}
