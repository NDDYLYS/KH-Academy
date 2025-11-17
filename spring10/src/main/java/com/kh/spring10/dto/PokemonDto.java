package com.kh.spring10.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PokemonDto 
{
	private Integer pokemonNo;
	private String pokemonName;
	private String pokemonType;
	private Integer pokemonLike;
}