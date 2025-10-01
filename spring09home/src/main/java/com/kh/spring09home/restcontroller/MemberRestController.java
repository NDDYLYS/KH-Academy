package com.kh.spring09home.restcontroller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.service.AttachmentService;

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
}