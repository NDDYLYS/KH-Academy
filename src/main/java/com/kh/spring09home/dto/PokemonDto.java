package com.kh.spring09home.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PokemonDto 
{
	private int pokemonNo;
	private String pokemonName;
	private String pokemonType;
	private int pokemonLike;
}