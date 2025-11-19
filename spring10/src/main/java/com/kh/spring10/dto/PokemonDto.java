package com.kh.spring10.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PokemonDto 
{
	private Integer pokemonNo;
	private String pokemonName;
	private String pokemonType;
	private Integer pokemonLike;
}