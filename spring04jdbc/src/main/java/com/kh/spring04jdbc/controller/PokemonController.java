//package com.kh.spring04jdbc.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/pokemon")
//public class PokemonController 
//{
//	// 스프링에 등록된 인스턴스를 주입하는 설정
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	// 목표 : pokemon/add라는 주소를 만들어서 포켓몬 등록 코드를 작성
//	@RequestMapping("/add")
//	public String add(@RequestParam String pokemonName,
//			@RequestParam String pokemonType) 
//	{
//		String sql = "insert into pokemon (pokemon_no, "
//				+ "pokemon_name, pokemon_type) values (pokemon_seq.nextval,"
//				+ "?, ?)";
//		Object[] params = {pokemonName, pokemonType};
//		jdbcTemplate.update(sql, params);
//		return "dasasdsad";
//	}
//}
