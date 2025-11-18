package com.kh.spring10.vo;
import java.util.List;
import com.kh.spring10.dto.PokemonDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PokemonListVO {
	private int page;
	private int count;
	private int size;
	private int begin, end;
	private boolean last;
	private List<PokemonDto> list;
}
