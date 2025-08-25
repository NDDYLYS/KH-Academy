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
import com.kh.spring09home.error.TargetNotfoundException;

import jakarta.servlet.http.HttpSession;

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
	
	@GetMapping("/login")
	public String login() 
	{
		return "/WEB-INF/views/member/login.jsp";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, 
			HttpSession session)
	//public String login(@RequestParam String memberId, 
	//		@RequestParam String memberPw) 
	{
		MemberDto findDto = memberDao.selectOne(memberDto.getMemberId());
		if (findDto == null)
			return "redirect:login?error";
		
		boolean isLogin = findDto.getMemberPw().equals(memberDto.getMemberPw());
		if (isLogin) 
		{
			session.setAttribute("loginId",  findDto.getMemberId());
			session.setAttribute("loginLevel",  findDto.getMemberLevel());
			return "redirect:/";
		}
		else 
		{
			
			return "redirect:login?error";
		}
	}
	
	// 로그아웃 : HttpSession에 저장해둔 데이터를 삭제한다
	@RequestMapping("/logout")
	public String logout(HttpSession session) 
	{
		session.removeAttribute("loginId");
		session.removeAttribute("loginLevel");
		return "redirect:/";
	}
	
	@RequestMapping("/mypage")
	public String mypage(Model model,
			HttpSession session) 
	{
		// session에서 loginId를 추출하여 정보 조회 뒤 화면으로 전달
		String loginId = (String) session.getAttribute("loginId");
		MemberDto memberDto = memberDao.selectOne(loginId);
		
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
	@GetMapping("/drop")
	public String drop()
	{
		return "/WEB-INF/views/member/drop.jsp";
	}
	
	@PostMapping("/drop")
	public String drop(HttpSession session, 
			@RequestParam String memberPw) 
	{
		String loginId = (String)session.getAttribute("loginId");
		MemberDto memberDto = memberDao.selectOne(loginId);
		boolean isValid = memberDto.getMemberPw().equals(memberPw);
		if (isValid) 
		{
			memberDao.delete(loginId);
			session.removeAttribute("loginId");
			session.removeAttribute("loginLevel");
			return "redirect:goodbye";
		} 
		else 
		{
			return "redirect:drop?error";
		}
	}
	
	@RequestMapping("/goodbye")
	public String goodbye() 
	{
		return "/WEB-INF/views/member/goodbye.jsp";
	}
	
	
	@GetMapping("/edit")
	public String edit(Model model,
				HttpSession session)
	{
		String memberId = (String)session.getAttribute("loginId");
		MemberDto memberDto = memberDao.selectOne(memberId);
		if (memberDto == null) 
		{
			//return "redirect:list"; // 에러페이지매핑
			//throw new RuntimeException("존재하지 않는 포켓몬 번호");
			throw new TargetNotfoundException("존재하지 않는 회원 아이디");
		}
		
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto) 
	{
		memberDao.update(memberDto);
		return "redirect:mypage";
	}
	
//	@GetMapping("/password")
//	public String password() 
//	{
//		return "/WEB-INF/views/member/password.jsp";
//	}
//	
//	@PostMapping("/password")
//	public String password(@ModelAttribute MemberDto memberDto, 
//			HttpSession session) 
//	{
//		String loginId = (String)session.getAttribute("loginId");
//		MemberDto loginUser = memberDao.selectOne(loginId);
//		MemberDto findDto = 
//		
//		memberDao.update(memberDto);
//		return "redirect:mypage";
//	}
}
