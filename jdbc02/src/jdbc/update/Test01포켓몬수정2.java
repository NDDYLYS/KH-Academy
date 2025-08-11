package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;
import jdbc.insert.JDBCHelper;

;

public class Test01포켓몬수정2 
{
    public static void main(String[] args) 
    {
    	// 한 번에 반드시 한 개의 데이터만 수정한다
    	// PK는 수정하지 않는 것이 원칙
    	// update pokemon set pokemon_name = ?, pokemon_type = ? where pokemon_no = ?
    	
    	PokemonDto pokemonDto = new PokemonDto();
    	pokemonDto.setPokemonNo(1);
    	pokemonDto.setPokemonName("asdzzzzz");
    	pokemonDto.setPokemonType("dddd1333333");
    	
    	PokemonDao pokemonDao = new PokemonDao();
    	boolean success = pokemonDao.update(pokemonDto);
    	if (success)
    		System.out.println("수정 완료");
    	else 
    		System.out.println("수정 실패");
    }
}