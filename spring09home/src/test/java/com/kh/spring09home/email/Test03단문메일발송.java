package com.kh.spring09home.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.kh.spring09home.service.EmailService;

@SpringBootTest
public class Test03단문메일발송 
{
	@Autowired
	private EmailService emailService;
	
	@Test
	public void test() 
	{
		emailService.sendEmail("nodvic89@gmail.com", "테스트 제목입니다33333", "테스트 내용입니다33333");
	}
}