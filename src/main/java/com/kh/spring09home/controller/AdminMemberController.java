package com.kh.spring09home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09home.dao.BoardDao;
import com.kh.spring09home.dao.BuyDao;
import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dto.BuyDto;
import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.error.TargetNotfoundException;
import com.kh.spring09home.vo.BoardListVO;
import com.kh.spring09home.vo.PageVO;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController 
{
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BuyDao buyDao;
	
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute(value = "pageVO") PageVO pageVO) 
	{
		model.addAttribute("memberList", memberDao.selectListWithPaging(pageVO));
		pageVO.setDataCount(memberDao.count(pageVO));
		model.addAttribute("pageVO", pageVO); // @ModelAttribute에 value 설정시 생략 가능
		
		return "/WEB-INF/views/admin/member/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model, 
			@RequestParam String memberId) 
	{
		MemberDto memberDto = memberDao.selectOne(memberId);
		if (memberDto == null)
			throw new TargetNotfoundException("존재하지 않는 회원");
		model.addAttribute("memberDto", memberDto);
		
		List<BoardListVO> boardList = boardDao.selectListByBoardWriter(memberId);
		model.addAttribute("boardList", boardList);
		
		List<BuyDto> buyList = buyDao.selectListByMemberId(memberId);
		model.addAttribute("buyList", buyList);
		
		return "/WEB-INF/views/admin/member/detail.jsp";
	}
}
