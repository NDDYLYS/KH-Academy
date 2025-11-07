package com.kh.spring09home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring09home.dao.BoardDao;
import com.kh.spring09home.dao.BoardLikeDao;
import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dao.PokemonDao;
import com.kh.spring09home.dao.PokemonLikeDao;
import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.error.TargetNotfoundException;

@Service
public class MemberService 
{
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardLikeDao boardLikeDao;
	@Autowired
	private PokemonDao pokemonDao;
	@Autowired
	private PokemonLikeDao pokemonLikeDao;
	@Autowired
	private AttachmentService attachmentService;
	
	@Transactional
	public boolean Drop(String memberId, String memberPw) 
	{
		MemberDto memberDto = memberDao.selectOne(memberId);
		if (memberDto == null)
			throw new TargetNotfoundException("존재하지 않는 회원");
		
		boolean isValid = memberDto.getMemberPw().equals(memberPw);
		if (isValid == false)
			return false;
		
		// 프로필 삭제
		try 
		{
			int attachmentNo = memberDao.findAttachment(memberId);
			attachmentService.delete(attachmentNo);
		}
		catch(Exception e) {}
		
		// 게시글 좋아요 이력 조회
		List<Integer> boardNoList = boardLikeDao.selectListByMemberId(memberId);
		
		// 포켓몬 좋아요 이력 조회
		List<Integer> pokemonNoList = pokemonLikeDao.selectListByMemberId(memberId);
		
		// 회원 정보 삭제
		memberDao.delete(memberId);
		
		// 조회한 번호에 해당하는 게시글과 포켓몬 좋아요 개수를 갱신
		for(int boardNo : boardNoList) 
		{
			boardDao.updateBoardLike(boardNo);
		}
		
		for(int pokemonNo : pokemonNoList) 
		{
			pokemonDao.updatePokemonLike(pokemonNo);
		}
		
		return true;
	}
}
