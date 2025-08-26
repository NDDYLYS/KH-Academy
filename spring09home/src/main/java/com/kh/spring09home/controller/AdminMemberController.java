package com.kh.spring09home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dto.MemberDto;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController 
{
	@Autowired
	private MemberDao memberDao;
	
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
		return "/WEB-INF/views/admin/member/list.jsp";
	}
}
