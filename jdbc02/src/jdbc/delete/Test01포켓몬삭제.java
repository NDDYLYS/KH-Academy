package jdbc.delete;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;

;

public class Test01포켓몬삭제 
{
    public static void main(String[] args) 
    {
    	PokemonDto pokemonDto = new PokemonDto();
    	pokemonDto.setPokemonNo(3);
    	
    	PokemonDao pokemonDao = new PokemonDao();
    	boolean success = pokemonDao.delete(pokemonDto.getPokemonNo());
    	if (success)
    		System.out.println("삭제 완료");
    	else 
    		System.out.println("삭제 실패");
    }
}