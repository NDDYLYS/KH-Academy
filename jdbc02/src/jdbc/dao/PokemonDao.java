package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.insert.JDBCHelper;
import jdbc.mapper.PokemonMapper;

;

// Data Access Object
// 테이블마다 1개씩 생성, 테이블과 이름을 연결지어서 작성
// CRUD Create, Read, Update, Delete
public class PokemonDao 
{
	
	
	// 등록 메소드(C)
	public void insert(PokemonDto pokemonDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		// OracleConnector connect = new OracleConnector();
		
		String insertinto = "insert into pokemon (pokemon_no, pokemon_name, pokemon_type) values (pokemon_seq.nextval, ?, ?)";
		Object[] param = {pokemonDto.getPokemonName(), pokemonDto.getPokemonType()};
		jdbcTemplate.update(insertinto, param);
		//connect.RunSQL(insertinto, param);
	}
	
	public boolean update(PokemonDto pokemonDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "update pokemon set pokemon_name=?, pokemon_type=? where pokemon_no = ?";
    	Object[] params = {pokemonDto.getPokemonName(), pokemonDto.getPokemonType(), pokemonDto.getPokemonNo()};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public boolean delete(int pokemonNo) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "delete pokemon where pokemon_no=?";
    	Object[] params = {pokemonNo};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<PokemonDto> selectList()
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "select * from pokemon order by pokemon_no asc";
    	PokemonMapper pokemonMapper = new PokemonMapper();
    	return jdbcTemplate.query(sql, pokemonMapper);
	}
}