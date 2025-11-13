package com.kh.spring10.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.kh.spring10.dto.PokemonDto;
import com.kh.spring10.mapper.PokemonMapper;

@Repository
public class PokemonDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PokemonMapper pokemonMapper;
	
	public int sequence() 
	{
		String sql = "select pokemon_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public void insert(PokemonDto pokemonDto) 
	{
		String sql = "insert into pokemon (pokemon_no, pokemon_name, pokemon_type) "
				+ "values (?, ?, ?)";
		Object[] params = {
				pokemonDto.getPokemonNo(),
				pokemonDto.getPokemonName(),
				pokemonDto.getPokemonType()};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(PokemonDto pokemonDto) 
	{
		String sql = "update pokemon set pokemon_name=?, pokemon_type=? "
    			+ "where pokemon_no=?";
    	Object[] params = {
    			pokemonDto.getPokemonName(), 
    			pokemonDto.getPokemonType(), 
    			pokemonDto.getPokemonNo()};
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
	

	public List<PokemonDto> selectList()
	{
		String sql = "select * from pokemon order by pokemon_no asc";
		return jdbcTemplate.query(sql, pokemonMapper);
	}
	
	public List<PokemonDto> selectList(String column, String keyword)
	{
    	Set<String> allowList = Set.of("pokemon_name", "pokemon_type");
		
		if (allowList.contains(column) == false)
			return List.of(); // 비어있는 리스트;		
		
		String sql = "select * from pokemon where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, pokemon_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, pokemonMapper, params);
	}
	
	public PokemonDto selectOne(int pokemon_no)
	{
		String sql = "select * from pokemon where pokemon_no=?";
		Object[] params = {pokemon_no};
		List<PokemonDto> list = jdbcTemplate.query(sql, pokemonMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
	/*
	 * public int count(PageVO pageVO) { if(pageVO.isList()) { String sql
	 * ="select count(*) from pokemon " + "order by pokemon_no asc"; return
	 * jdbcTemplate.queryForObject(sql, int.class); } else { String sql
	 * ="select count(*) from pokemon " + "where instr(#1, ?) > 0"; sql =
	 * sql.replace("#1", pageVO.getColumn()); Object[] params =
	 * {pageVO.getKeyword()}; return jdbcTemplate.queryForObject(sql, int.class,
	 * params); } }
	 */

	/*
	 * public List<PokemonDto> selectListWithPaging(PageVO pageVO) {
	 * if(pageVO.isList()) {//목록이라면 String sql = "select * from (" +
	 * "select rownum rn, TMP.* from (" + "select * from pokemon " +
	 * "order by pokemon_no desc" + ")TMP" + ") where rn between ? and ?";
	 * 
	 * Object[] params = { pageVO.getBegin(), pageVO.getEnd() };//동적할당 return
	 * jdbcTemplate.query(sql, pokemonMapper, params); } else {//검색이라면 String sql =
	 * "select * from (" + "select rownum rn, TMP.* from (" +
	 * "select * from pokemon " + "where instr(#1, ?) > 0" +
	 * "order by #1 asc, pokemon_no desc" + ")TMP" + ") where rn between ? and ?";
	 * sql = sql.replace("#1", pageVO.getColumn()); Object[] params = {
	 * pageVO.getKeyword(), pageVO.getBegin(), pageVO.getEnd() };//동적할당 return
	 * jdbcTemplate.query(sql, pokemonMapper, params); } }
	 */
	public void connect(int pokemonNo, int attachmentNo) 
	{
		String sql = "insert into pokemon_image (pokemon_no, attachment_no) values (?, ?)";
		Object[] params = {
				pokemonNo, 
				attachmentNo
		};//동적할당
		jdbcTemplate.update(sql, params);
	}
	
	public int findAttachment(int pokemonNo) 
	{
		String sql = "select attachment_no from pokemon_image where pokemon_no = ?";
		Object[] params = {pokemonNo};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	
	// 좋아요 개수 갱신
	public boolean updatePokemonLike(int pokemonNo, int pokemonLike) 
	{
		String sql = "update pokemon set pokemon_like = ? where pokemon_no = ?";
		Object[] params = {pokemonLike, pokemonNo};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	public boolean updatePokemonLike(int pokemonNo) 
	{
		String sql = "update pokemon "
						+ "set pokemon_like = (select count(*) from pokemon_like where pokemon_no = ?) "
						+ "where pokemon_no = ?";
		Object[] params = {pokemonNo, pokemonNo};
		return jdbcTemplate.update(sql, params) > 0;
	}
}