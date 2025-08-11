package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.insert.JDBCHelper;
import jdbc.util.OracleConnector;

;

public class Test01포켓몬수정 
{
    public static void main(String[] args) 
    {
    	// 한 번에 반드시 한 개의 데이터만 수정한다
    	// PK는 수정하지 않는 것이 원칙
    	// update pokemon set pokemon_name = ?, pokemon_type = ? where pokemon_no = ?
    	
    	int pokemonNo = 1;
    	String pokemonName = "ddddd123";
    	String pokemonType = "asdzzcx";
    	
    	JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "update pokemon set pokemon_name=?, pokemon_type=? where pokemon_no = ?";
    	Object[] params = {pokemonName, pokemonType, pokemonNo};
    	int result = jdbcTemplate.update(sql, params);
    	if (0 < result)
    		System.out.println("수정 완료");
    	else 
    		System.out.println("수정 실패");
    }
}