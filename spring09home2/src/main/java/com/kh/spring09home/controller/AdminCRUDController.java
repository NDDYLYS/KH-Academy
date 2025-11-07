package com.kh.spring09home.controller;

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
import com.kh.spring09home.error.TargetNotfoundException;
import com.kh.spring09home.service.AttachmentService;

@Controller
@RequestMapping("/admin/crud")
public class AdminCRUDController 
{
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private AttachmentService attachmentService;
	
	@GetMapping("/drop")
	public String drop()
	{
		return "/WEB-INF/views/admin/crud/drop.jsp";
	}
	
	@PostMapping("/drop")
	public String drop(@RequestParam String memberId) 
	{
		MemberDto memberDto = memberDao.selectOne(memberId);
		if (memberDto == null)
			throw new TargetNotfoundException("존재하지 않는 회원");
		
		try 
		{
			int attachmentNo = memberDao.findAttachment(memberDto.getMemberId());
			attachmentService.delete(attachmentNo);
		}
		catch(Exception e) { /*아무것도 안함*/ }
		
		memberDao.delete(memberId);
		return "redirect:goodbye";
	}
	
	@RequestMapping("/goodbye")
	public String goodbye() 
	{
		return "/WEB-INF/views/admin/crud/goodbye.jsp";
	}
	
	
	@GetMapping("/edit")
	public String edit(Model model,
			@RequestParam String memberId)
	{
		MemberDto memberDto = memberDao.selectOne(memberId);
		if (memberDto == null)
			throw new TargetNotfoundException("존재하지 않는 회원");
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/crud/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto) 
	{
		if (memberDto == null)
			throw new TargetNotfoundException("존재하지 않는 회원");
		memberDao.updateMember(memberDto);
		return "redirect:/admin/member/detail?memberId=" + memberDto.getMemberId();
	}
	
	@GetMapping("/password")
	public String password(Model model,
			@RequestParam String memberId) 
	{
		MemberDto memberDto = memberDao.selectOne(memberId);
		if (memberDto == null)
			throw new TargetNotfoundException("존재하지 않는 회원");
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/crud/password.jsp";
	}
	
	@PostMapping("/password")
	public String password(@ModelAttribute MemberDto memberDto) 
	{
		if (memberDto == null)
			throw new TargetNotfoundException("존재하지 않는 회원");
		memberDao.updatePassword(memberDto);
		return "redirect:/admin/member/detail?memberId=" + memberDto.getMemberId();
	}
}
