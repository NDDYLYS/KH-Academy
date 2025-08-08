package jdbc.dto;;

public class PokemonDto 
{
	private int pokemonNo;
	private String pokemonName;
	private String pokemonType;
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
	public PokemonDto() {
		super();
	}
	@Override
	public String toString() {
		return "PoketmonDto [pokemonNo=" + pokemonNo + ", pokemonName=" + pokemonName + ", pokemonType=" + pokemonType
				+ "]";
	}
}