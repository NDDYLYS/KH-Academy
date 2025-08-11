package jdbc.delete;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;

;

public class Test01포켓몬삭제2 
{
    public static void main(String[] args) 
    {
    	int pokemonNo = 99;
    	
    	PokemonDao pokemonDao = new PokemonDao();
    	boolean success = pokemonDao.delete(pokemonNo);
    	if (success)
    		System.out.println("삭제 완료");
    	else 
    		System.out.println("삭제 실패");
    }
}