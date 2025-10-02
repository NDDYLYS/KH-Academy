package com.kh.spring09home.restcontroller;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09home.dao.CertDao;
import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dto.CertDto;
import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.service.AttachmentService;
import com.kh.spring09home.service.EmailService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/rest/member")
public class MemberRestController 
{
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private CertDao certDao;
	
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
	
	// 프로필 변경 매핑
	@PostMapping("/profile")
	public void profile(HttpSession session, @RequestParam MultipartFile attach) throws IllegalStateException, IOException 
	{
		String loginId = (String)session.getAttribute("loginId");
		
		//기존 파일 삭제 (없을 수도 있음)
		try 
		{
			int attachmentNo = memberDao.findAttachment(loginId);
			attachmentService.delete(attachmentNo);
		}
		catch(Exception e) {/*아무것도 안함*/}
		
		//신규파일 등록
		if(attach.isEmpty() == false) 
		{
			int attachmentNo = attachmentService.save(attach);
			memberDao.connect(loginId, attachmentNo);
		}
	}
	
	@PostMapping("/delete")
	public String delete(HttpSession session) 
	{
		String loginId = (String)session.getAttribute("loginId");
		
		//기존 파일 삭제 (없을 수도 있음)
		try 
		{
			int attachmentNo = memberDao.findAttachment(loginId);
			attachmentService.delete(attachmentNo);
		}
		catch(Exception e) {/*아무것도 안함*/}
		
		return "redirect:/images/error/no-image.png";
	}
	
	@PostMapping("/certSend")
	public void certSend(@RequestParam String certEmail) 
	{
		emailService.sendCertNumber(certEmail);
	}
	
	@PostMapping("/certCheck")
	public boolean certCheck(@ModelAttribute CertDto certDto) 
	{
		CertDto findDto = certDao.selectOne(certDto.getCertEmail());
		if (findDto == null)
			return false; // 인증 메일을 보낸 적이 없다
		
		LocalDateTime current = LocalDateTime.now();
		LocalDateTime sent = findDto.getCertTime().toLocalDateTime();
		Duration duration = Duration.between(sent, current);
		//if (duration.toMinutes() > 10) // 10분 59초 초과
		if (duration.toSeconds() > 60) // 600초 초과
			return false;
			
		boolean isValid = certDto.getCertNumber().equals(findDto.getCertNumber());
		if (isValid == false)
			return false; // 인증번호가 틀렸다
		
		// 인증 통과
		certDao.delete(certDto.getCertEmail());
		return true;
	}
}