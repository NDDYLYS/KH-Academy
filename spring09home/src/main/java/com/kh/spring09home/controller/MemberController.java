package com.kh.spring09home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dto.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController 
{
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/join")
	public String join() 
	{
		return "/WEB-INF/views/member/join.jsp";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) 
	{
		memberDao.insert(memberDto);
		return "redirect:joinFinish";
	}
	
	@RequestMapping("/joinFinish")
	public String joinFinish() 
	{
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
	
	@RequestMapping("/list")
	public String list(Model model,
					@RequestParam(required = false) String column,
					@RequestParam(required = false) String keyword) 
	{
		boolean isSearch = column != null && keyword != null;
		model.addAttribute("isSearch", isSearch);
		
		if (isSearch) 
		{
			List<MemberDto> memberList = memberDao.selectList(column, keyword);
			model.addAttribute("memberList", memberList);			
		}
		else 
		{
			List<MemberDto> memberList = memberDao.selectList();
			model.addAttribute("memberList", memberList);
		}
		return "/WEB-INF/views/member/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model, 
			@RequestParam String memberId) 
	{
		MemberDto memberDto = memberDao.selectOne(memberId);
		model.addAttribute("memberDto", memberDto);
		
		return "/WEB-INF/views/member/detail.jsp";
	}
}
