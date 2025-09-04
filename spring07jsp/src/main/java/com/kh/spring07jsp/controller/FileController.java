package com.kh.spring07jsp.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring07jsp.dao.AttachmentDao;
import com.kh.spring07jsp.dto.AttachmentDto;

@Controller
@RequestMapping("/file")
public class FileController 
{
	@Autowired
	private AttachmentDao attachmentDao;
	
	@RequestMapping("/test01")
	public String test01() {
		return "/WEB-INF/views/file/test01.jsp";
	}
	
	@GetMapping("/test02")
	public String test02 (@RequestParam String uploader, @RequestParam MultipartFile attach) 
	{
		System.out.println("file : " + attach.getName());
		System.out.println("file : " + attach.getSize());
		return "redirect:test01";
	}
	
	@PostMapping("/test03")
	public String test03 (@RequestParam String uploader, @RequestParam  MultipartFile attach) 
	{
		System.out.println("file : " + attach.getName());
		System.out.println("file : " + attach.getSize());
		return "redirect:test01";
	}
	
	// 기존 정보는 그대로 수신 가능
	// 파일 정보는 MultipartFile 클래스로 한 번에 수신 가능(파일명, 크기, 유형)
	@PostMapping("/test04")
	public String test04 (@RequestParam String uploader, @RequestParam MultipartFile attach) throws IllegalStateException, IOException 
	{
		int attachmentNo = attachmentDao.sequence();
//		
//		System.out.println("uploader : " + uploader); // 업로드한 입력창 이름
//		System.out.println("업로드한 입력창 이름 : " + attach.getName()); // 업로드한 입력창 이름
//		System.out.println("파일명 : " + attach.getOriginalFilename()); // 파일명
//		System.out.println("파일 크기 : " + attach.getSize()); // 파일 크기
//		System.out.println("업로드한 파일 유형 : " + attach.getContentType()); // 업로드한 파일 유형
//		System.out.println("고유번호 : " + attach); // 고유번호
		
		if (!attach.isEmpty()) 
		{
			File home = new File(System.getProperty("user.home"));
			File upload = new File(home, "upload");
			if (upload.exists() == false) 
			{
				upload.mkdirs();
			}
			
			File target = new File(upload, String.valueOf(attachmentNo)); // 저장할 파일의 인스턴스
			attach.transferTo(target);
		}
		

		AttachmentDto attachmentDto = new AttachmentDto();
		attachmentDto.setAttachmentNo(attachmentNo);
		attachmentDto.setAttachmentName(attach.getOriginalFilename());
		attachmentDto.setAttachmentType(attach.getContentType());
		attachmentDto.setAttachmentSize(attach.getSize());
		
		attachmentDao.insert(attachmentDto);
		
		return "redirect:test01";
	}
}
