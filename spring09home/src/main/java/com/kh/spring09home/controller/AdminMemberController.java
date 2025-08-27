package com.kh.spring09home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.error.TargetNotfoundException;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController 
{
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/list")
	public String list(Model model,
					HttpSession session,
					@RequestParam(required = false) String column,
					@RequestParam(required = false) String keyword) 
	{
		boolean isSearch = column != null && keyword != null;
		model.addAttribute("isSearch", isSearch);
		String loginId = (String)session.getAttribute("loginId");
		
		if (isSearch) 
		{
			List<MemberDto> memberList = memberDao.selectListByAdmin(loginId, column, keyword);
			model.addAttribute("memberList", memberList);			
		}
		else 
		{
			List<MemberDto> memberList = memberDao.selectListByAdmin(loginId);
			model.addAttribute("memberList", memberList);
		}
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
		
		return "/WEB-INF/views/admin/member/detail.jsp";
	}
}
