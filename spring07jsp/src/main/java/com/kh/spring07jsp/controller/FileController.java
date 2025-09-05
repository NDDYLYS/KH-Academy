package com.kh.spring07jsp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring07jsp.dao.AttachmentDao;
import com.kh.spring07jsp.dto.AttachmentDto;
import com.kh.spring07jsp.error.TargetNotfoundException;
import com.kh.spring07jsp.service.AttachmentService;

@Controller
@RequestMapping("/file")
public class FileController 
{
	@Autowired
	private AttachmentService attachmentService;
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
		if (!attach.isEmpty()) 
		{
			int attachmentNo = attachmentService.save(attach);
		}
		
		return "redirect:test01";
	}
	
	@GetMapping("/download")
	public ResponseEntity<ByteArrayResource> download(@RequestParam int attachmentNo) throws IOException 
	{
		// DB에서 정보 조회
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
		if (attachmentDao == null)
			throw new TargetNotfoundException("존재하지 않는 파일");
		
		// 파일의 정보 읽기
		File home = new File(System.getProperty("user.home"));
		File upload = new File(home, "upload");
		File target = new File(upload, String.valueOf(attachmentNo));
		
		// java.nio 패키지의 명령
		byte[] data = Files.readAllBytes(target.toPath());
		ByteArrayResource resource = new ByteArrayResource(data);
		
		// 사용자에게 정보(header)와 내용(body)을 담아서 전송
		// 형태를 모르면 application/octet-stream
		// Content-Length는 전송할 파일의 크기
		// Content-Disposition는 body에 담긴 데이터를 어떻게 처리할지
		// inline 으로 작성하면 
		// attachment
		return ResponseEntity.ok()
				.header("Content-Encoding", "UTF-8") // 이건 UTF-8이다
				.header("Content-Type", attachmentDto.getAttachmentType()) // db에 저장된 AttachmentType
				.header("Content-Length", String.valueOf(attachmentDto.getAttachmentSize()))
				.header("Content-Disposition", "attachment; filename=" + attachmentDto.getAttachmentName())
				.body(resource);
	}
}
