package com.kh.spring09home.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09home.dao.AttachmentDao;
import com.kh.spring09home.dto.AttachmentDto;
import com.kh.spring09home.error.TargetNotfoundException;

@Service // 각종 도구들을 주입하여 거대한 목표를 달성하기 위한 복잡한 코드를 메소드로 가지는 도구
// 상품구매 : 회원포인트 검사/차감 + 상품재고검사/차감 + 구매이력기록
public class AttachmentService 
{
	@Autowired
	private AttachmentDao attachmentDao;
	
	private File home = new File(System.getProperty("user.home"));
	private File upload = new File(home, "upload");
	
	@Transactional // 이 메소드를 하나의 트랜잭션으로 간주(이 안에서의 DB 작업은 일괄로 처리/취소)
	public int save(MultipartFile attach) throws IllegalStateException, IOException 
	{
		int attachmentNo = attachmentDao.sequence();
		
		if (upload.exists() == false) 
			upload.mkdirs();
		
		File target = new File(upload, String.valueOf(attachmentNo)); // 저장할 파일의 인스턴스
		attach.transferTo(target);
		
		AttachmentDto attachmentDto = new AttachmentDto();
		attachmentDto.setAttachmentNo(attachmentNo);
		attachmentDto.setAttachmentName(attach.getOriginalFilename());
		attachmentDto.setAttachmentType(attach.getContentType());
		attachmentDto.setAttachmentSize(attach.getSize());
		
		attachmentDao.insert(attachmentDto);
		
		return attachmentNo;
	}
	
	public ByteArrayResource load(int attachmentNo) throws IOException 
	{	
		// 파일의 정보 읽기
		File home = new File(System.getProperty("user.home"));
		File upload = new File(home, "upload");
		File target = new File(upload, String.valueOf(attachmentNo));
		
		if (!target.isFile())
			throw new TargetNotfoundException("존재하지 않는 파일");
		
		// java.nio 패키지의 명령
		byte[] data = Files.readAllBytes(target.toPath());
		ByteArrayResource resource = new ByteArrayResource(data);
		return resource;
	}
}
