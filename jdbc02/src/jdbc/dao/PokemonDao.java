package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.insert.JDBCHelper;

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
}