package com.kh.spring09home.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09home.dao.PokemonDao;
import com.kh.spring09home.dao.PokemonLikeDao;
import com.kh.spring09home.vo.PokemonLikeVO;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/rest/pokemon")
public class PokemonRestController 
{
	@Autowired
	private PokemonLikeDao pokemonLikeDao;
	@Autowired
	private PokemonDao pokemonDao;
	
	@PostMapping("/check")
	public PokemonLikeVO check(HttpSession session, @RequestParam int pokemonNo) 
	{
		String loginId = (String)session.getAttribute("loginId");
		boolean result = pokemonLikeDao.check(loginId, pokemonNo);		
		int count = pokemonLikeDao.countByPokemonNo(pokemonNo);
		
		PokemonLikeVO pokemonLikeVO = new PokemonLikeVO();
		pokemonLikeVO.setLike(result);
		pokemonLikeVO.setCount(count);
		return pokemonLikeVO;// return PokemonLikeVO.builder().like(like).count(count).build();
	}
	
	@PostMapping("/action")
	public PokemonLikeVO action(HttpSession session, @RequestParam int pokemonNo) 
	{
		String loginId = (String)session.getAttribute("loginId");
		
		PokemonLikeVO pokemonLikeVO = new PokemonLikeVO();
		boolean like = pokemonLikeDao.check(loginId, pokemonNo);
		if(like) 
		{	//좋아요를 누른 이력이 있으면
			pokemonLikeDao.delete(loginId, pokemonNo);
			pokemonLikeVO.setLike(false);
		}
		else 
		{ 	//좋아요를 누른 이력이 없으면
			pokemonLikeDao.insert(loginId, pokemonNo);
			pokemonLikeVO.setLike(true);
		}
		int count = pokemonLikeDao.countByPokemonNo(pokemonNo);
		pokemonDao.updatePokemonLike(pokemonNo, count);
		pokemonLikeVO.setCount(count);
		return pokemonLikeVO;
		// return PokemonLikeVO.builder().like(!like).count(count).build();
	}
}