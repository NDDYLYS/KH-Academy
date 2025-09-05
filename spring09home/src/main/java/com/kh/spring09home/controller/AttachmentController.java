package com.kh.spring09home.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09home.dao.AttachmentDao;
import com.kh.spring09home.dto.AttachmentDto;
import com.kh.spring09home.error.TargetNotfoundException;
import com.kh.spring09home.service.AttachmentService;

@Controller
@RequestMapping("/attachment")
public class AttachmentController 
{
	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private AttachmentDao attachmentDao;
	
	@GetMapping("/download")
	public ResponseEntity<ByteArrayResource> download(@RequestParam int attachmentNo) throws IOException 
	{
		// DB에서 정보 조회
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
		if (attachmentDao == null)
			throw new TargetNotfoundException("존재하지 않는 파일");
		
		ByteArrayResource resource = attachmentService.load(attachmentNo);
		
		// 사용자에게 정보(header)와 내용(body)을 담아서 전송
		// 형태를 모르면 application/octet-stream
		// Content-Length는 전송할 파일의 크기
		// Content-Disposition는 body에 담긴 데이터를 어떻게 처리할지
		// inline 으로 작성하면 
		// attachment
//		return ResponseEntity.ok()
//				.header("Content-Encoding", "UTF-8") // 이건 UTF-8이다
//				.header("Content-Type", attachmentDto.getAttachmentType()) // db에 저장된 AttachmentType
//				.header("Content-Length", String.valueOf(attachmentDto.getAttachmentSize()))
//				.header("Content-Disposition", "attachment; filename=" + attachmentDto.getAttachmentName())
//				.body(resource);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
				.header(HttpHeaders.CONTENT_TYPE, attachmentDto.getAttachmentType())
				.contentLength(attachmentDto.getAttachmentSize())
				.header(HttpHeaders.CONTENT_DISPOSITION, 
						ContentDisposition.attachment().filename(attachmentDto.getAttachmentName(), StandardCharsets.UTF_8).build().toString())
				.body(resource);
	}
}