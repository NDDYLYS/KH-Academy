package jdbc.select;

import java.util.List;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;

public class Test01포켓몬조회 
{
    public static void main(String[] args) 
    {
    	// select
    	// 오라클의 표 모양의 데이터를 자바의 List<DTO>로 교체한다 => RowMapper<PokemonDto>
    	PokemonDao pokemonDao = new PokemonDao();
    	List<PokemonDto> list = pokemonDao.selectList();
    	
    	System.out.println("조회 결과 : " + list.size() + "개");
    	for (PokemonDto pokemonDto : list) 
    	{
    		System.out.println(pokemonDto);
    	}
    }
}