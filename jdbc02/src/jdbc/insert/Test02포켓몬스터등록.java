package jdbc.insert;
import java.util.Scanner;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;
import jdbc.util.OracleConnector;

public class Test02포켓몬스터등록 
{
    public static void main(String[] args) 
    {
    	//JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	OracleConnector connect = new OracleConnector();
		
    	Scanner sc = new Scanner(System.in);
    	
    	while(true) 
    	{
    		System.out.print("이름을 입력해주세요 : ");
    		String pokemonName = sc.nextLine();
    		if (pokemonName.equals("종료"))
    			break;
    		
    		System.out.print("속성을 입력해주세요 : ");
    		String pokemonType = sc.nextLine();
      		
      		PokemonDto pokemonDto = new PokemonDto();
      		pokemonDto.setPokemonName(pokemonName);
      		pokemonDto.setPokemonType(pokemonType);
      		
    		PokemonDao pokemonDao = new PokemonDao();
    		pokemonDao.insert(pokemonDto);
    		
    		System.out.println("포켓몬 " + pokemonName + "가 입력되었습니다.");
    	}
    }
}