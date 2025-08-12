package com.kh.spring04jdbc.dto;

// 일회용이라 등록 안 함
public class PokemonDto 
{
	private int pokemonNo;
	private String pokemonName;
	private String pokemonType;
	
	public PokemonDto() 
	{
	}

	public int getPokemonNo() {
		return pokemonNo;
	}

	public void setPokemonNo(int pokemonNo) {
		this.pokemonNo = pokemonNo;
	}

	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}

	public String getPokemonType() {
		return pokemonType;
	}

	public void setPokemonType(String pokemonType) {
		this.pokemonType = pokemonType;
	}

	@Override
	public String toString() {
		return "PokemonDto [pokemonNo=" + pokemonNo + ", pokemonName=" + pokemonName + ", pokemonType=" + pokemonType
				+ "]";
	}
}