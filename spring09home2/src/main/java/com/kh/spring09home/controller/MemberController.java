package com.kh.spring09home.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09home.dao.BoardDao;
import com.kh.spring09home.dao.BuyDao;
import com.kh.spring09home.dao.CertDao;
import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dto.BuyDto;
import com.kh.spring09home.dto.CertDto;
import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.error.NeedPermissionException;
import com.kh.spring09home.error.TargetNotfoundException;
import com.kh.spring09home.service.AttachmentService;
import com.kh.spring09home.service.EmailService;
import com.kh.spring09home.service.MemberService;
import com.kh.spring09home.vo.BoardListVO;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController 
{
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BuyDao buyDao;
	@Autowired
	private MemberService memberService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private CertDao certDao;
	
	
	@GetMapping("/join")
	public String join() 
	{
		return "/WEB-INF/views/member/join.jsp";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto,
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException, MessagingException 
	{
		memberDao.insert(memberDto);
		
		if(!attach.isEmpty()) 
		{
			int attachmentNo = attachmentService.save(attach);
			memberDao.connect(memberDto.getMemberId(), attachmentNo);
		}
		
		
		// 가입 완료 메일 발송
		emailService.sendWelcomeMail(memberDto);
		
		return "redirect:joinFinish";
	}
	
	@RequestMapping("/joinFinish")
	public String joinFinish() 
	{
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
	
//	@RequestMapping("/list")
//	public String list(Model model,
//					@RequestParam(required = false) String column,
//					@RequestParam(required = false) String keyword) 
//	{
//		boolean isSearch = column != null && keyword != null;
//		model.addAttribute("isSearch", isSearch);
//		
//		if (isSearch) 
//		{
//			List<MemberDto> memberList = memberDao.selectList(column, keyword);
//			model.addAttribute("memberList", memberList);			
//		}
//		else 
//		{
//			List<MemberDto> memberList = memberDao.selectList();
//			model.addAttribute("memberList", memberList);
//		}
//		return "/WEB-INF/views/member/list.jsp";
//	}
	
//	@RequestMapping("/detail")
//	public String detail(Model model, 
//			@RequestParam String memberId) 
//	{
//		MemberDto memberDto = memberDao.selectOne(memberId);
//		model.addAttribute("memberDto", memberDto);
//		
//		return "/WEB-INF/views/member/detail.jsp";
//	}
	
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
			
			memberDao.loginUser(findDto.getMemberId());
			
			if (findDto.getMemberChange() != null) 
			{				
				Timestamp now = new Timestamp(System.currentTimeMillis());
				Timestamp lastChange = findDto.getMemberChange();
				Calendar cal = Calendar.getInstance();
				cal.setTime(lastChange);
				cal.add(Calendar.DAY_OF_MONTH, 30); // 30일 뒤
				if (now.after(lastChange))
					return "redirect:password";
			}
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
		
		List<BoardListVO> boardList = boardDao.selectListByBoardWriter(loginId);
		model.addAttribute("boardList", boardList);
		
		List<BuyDto> buyList = buyDao.selectListByMemberId(loginId);
		model.addAttribute("buyList", buyList);
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
		if (memberDto == null)
			throw new TargetNotfoundException("존재하지 않는 회원 아이디 번호");
		
		boolean result = memberService.Drop(loginId, memberPw);//memberDto.getMemberPw().equals(memberPw);
		if (result) 
		{
			try 
			{
				int attachmentNo = memberDao.findAttachment(loginId);
				attachmentService.delete(attachmentNo);
			}
			catch(Exception e) { /*아무것도 안함*/ }			
				
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
		String loginId = (String)session.getAttribute("loginId");
		MemberDto memberDto = memberDao.selectOne(loginId);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto,
			HttpSession session) 
	{
		String loginId = (String)session.getAttribute("loginId");
		MemberDto findDto = memberDao.selectOne(loginId);
		boolean isValid = memberDto.getMemberPw().equals(findDto.getMemberPw());
		if (!isValid) 
			return "redirect:edit?error";
		
		memberDto.setMemberId(loginId);
		memberDao.updateMember(memberDto);
		return "redirect:mypage";
	}
	
	@GetMapping("/password")
	public String password() 
	{
		return "/WEB-INF/views/member/password.jsp";
	}
	
	@PostMapping("/password")
	public String password(@RequestParam String oldPassword, 
			@RequestParam String newPassword,
			HttpSession session) 
	{
		String loginId = (String)session.getAttribute("loginId");
		MemberDto loginMember = memberDao.selectOne(loginId);
		
		if (!loginMember.getMemberPw().equals(oldPassword))
			 return "redirect:password?error";
		
		MemberDto memberDto = new MemberDto();
		// memberDto.setMemberId(loginId); 없어도 된다
		memberDto.setMemberPw(newPassword);
		memberDao.updatePassword(memberDto);
		return "redirect:mypage";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model,
			@RequestParam String memberId) 
	{
		if (memberId == null)
			throw new TargetNotfoundException("탈퇴한 회원입니다");
		
		MemberDto memberDto = memberDao.selectOne(memberId);
		model.addAttribute("memberDto", memberDto);

		List<BoardListVO> boardList = boardDao.selectListByBoardWriter(memberId);
		model.addAttribute("boardList", boardList);
		
		List<BuyDto> buyList = buyDao.selectListByMemberId(memberId);
		model.addAttribute("buyList", buyList);
		
		return "/WEB-INF/views/member/detail.jsp";
	}
	
	
	@GetMapping("/profile")
	public String profile(@RequestParam String memberId) 
	{
		try 
		{
			int attachmentNo = memberDao.findAttachment(memberId);
			return "redirect:/attachment/download?attachmentNo=" + attachmentNo;			
		}
		catch(Exception e) 
		{
			return "redirect:/images/error/no-image.png";
		}
	}
	
	@GetMapping("/findMemberId")
	public String findMemberId() 
	{
		return "/WEB-INF/views/member/findMemberId.jsp";
	}
	
	@PostMapping("/findMemberId")
	public String findMemberId(@ModelAttribute MemberDto memberDto) 
	{
		MemberDto findDto = memberDao.selectOneByMemberNickname(memberDto.getMemberNickname());
		if (findDto == null)
			return "redirect:findMemberId?error";
		boolean emailValid = memberDto.getMemberEmail().equals(findDto.getMemberEmail());
		if (emailValid == false)
			return "redirect:findMemberId?error";
		
		emailService.sendEmail(
				findDto.getMemberEmail(), // "nodvic89@gmail.com",
				"아이디 찾기 결과", 
				"너님 아이디는 [" + findDto.getMemberId() + "]입니다.");
		
		return "redirect:findMemberIdFinish";
	}
	

	@RequestMapping("/findMemberIdFinish")
	public String findMemberIdFinish() 
	{
		return "/WEB-INF/views/member/findMemberIdFinish.jsp";
	}
	
	@GetMapping("/changeMemberPw")
	public String changeMemberPw(
			@RequestParam String memberId,//회원 아이디
			@RequestParam String certNumber,//인증번호
			Model model) {
		
		//아이디로 이메일을 찾아서 인증내역을 조회
		MemberDto memberDto = memberDao.selectOne(memberId);//아이디 존재?
		if(memberDto == null) throw new TargetNotfoundException("존재하지 않는 회원");
		CertDto certDto = certDao.selectOne(memberDto.getMemberEmail());//인증내역 존재?
		if(certDto == null) throw new NeedPermissionException("허가받지 않은 접근");
		boolean numberValid = certDto.getCertNumber().equals(certNumber);//인증번호 일치?
		if(numberValid == false) throw new NeedPermissionException("허가받지 않은 접근");
		LocalDateTime current = LocalDateTime.now();//현재시각
		LocalDateTime created = certDto.getCertTime().toLocalDateTime();//인증생성시각
		Duration duration = Duration.between(created, current);
		//boolean timeValid = duration.toMinutes() <= 10;//10분 59초까지
		boolean timeValid = duration.toSeconds() <= 600;//10분 0초까지
		if(timeValid == false) throw new NeedPermissionException("인증정보 만료됨");
		
		//certDao.delete(memberDto.getMemberEmail());//인증정보 재사용 금지(삭제)
		
		model.addAttribute("memberId", memberId);
		model.addAttribute("certNumber", certNumber);
		
		return "/WEB-INF/views/member/changeMemberPw.jsp";
	}
	
	@PostMapping("/changeMemberPw")
	public String changeMemberPw(
			@ModelAttribute MemberDto memberDto,
			@RequestParam String certNumber) {
		MemberDto findDto = memberDao.selectOne(memberDto.getMemberId());
		if(findDto == null) return "redirect:changeMemberPw?error";
		
		//아이디로 이메일을 찾아서 인증내역을 조회
		CertDto certDto = certDao.selectOne(findDto.getMemberEmail());//인증내역 존재?
		if(certDto == null) throw new NeedPermissionException("허가받지 않은 접근");
		boolean numberValid = certDto.getCertNumber().equals(certNumber);//인증번호 일치?
		if(numberValid == false) throw new NeedPermissionException("허가받지 않은 접근");
		LocalDateTime current = LocalDateTime.now();//현재시각
		LocalDateTime created = certDto.getCertTime().toLocalDateTime();//인증생성시각
		Duration duration = Duration.between(created, current);
		//boolean timeValid = duration.toMinutes() <= 10;//10분 59초까지
		boolean timeValid = duration.toSeconds() <= 600;//10분 0초까지
		if(timeValid == false) throw new NeedPermissionException("인증정보 만료됨");
		
		memberDao.updatePassword(memberDto);//비밀번호 변경
		certDao.delete(findDto.getMemberEmail());//인증정보 재사용 금지(삭제)
		
		return "redirect:changeMemberPwFinish";
	}
	

	@RequestMapping("/changeMemberPwFinish")
	public String changeMemberPwFinish() 
	{
		return "/WEB-INF/views/member/changeMemberPwFinish.jsp";
	}
	
	@GetMapping("/findMemberPw")
	public String findMemberPw() 
	{
		return "/WEB-INF/views/member/findMemberPw.jsp";
	}
	
	@PostMapping("/findMemberPw")
	public String findMemberPw(@ModelAttribute MemberDto memberDto) throws MessagingException, IOException 
	{
		MemberDto findDto = memberDao.selectOne(memberDto.getMemberId());
		if (findDto == null)
			return "redirect:findMemberPw?error";
		boolean nicknameValid = memberDto.getMemberNickname().equals(findDto.getMemberNickname());
		if (nicknameValid == false)
			return "redirect:findMemberPw?error";
		boolean emailValid = memberDto.getMemberEmail().equals(findDto.getMemberEmail());
		if (emailValid == false)
			return "redirect:findMemberPw?error";
		
		emailService.sendResetPassword(memberDto);
		
		return "redirect:findMemberPwFinish";
	}
	

	@RequestMapping("/findMemberPwFinish")
	public String findMemberPwFinish() 
	{
		return "/WEB-INF/views/member/findMemberPwFinish.jsp";
	}
}
