package com.kh.spring09home.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09home.dao.BoardLikeDao;
import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.vo.BoardLikeVO;

@CrossOrigin
@RestController
@RequestMapping("/rest/member")
public class MemberRestController 
{
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/checkMemberId")
	public boolean checkMemberId(@RequestParam String memberId)
	{
		MemberDto memberDto = memberDao.selectOne(memberId);
		boolean result = (memberDto != null);		
		return result;
	}
	
	@RequestMapping("/checkMemberNickname")
	public boolean checkMemberNickname(@RequestParam String memberNickname)
	{
		MemberDto memberDto = memberDao.selectOneByMemberNickname(memberNickname);
		return memberDto != null;
	}
}