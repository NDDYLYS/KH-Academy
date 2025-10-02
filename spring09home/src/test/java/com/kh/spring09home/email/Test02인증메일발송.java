package com.kh.spring09home.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring09home.service.EmailService;

@SpringBootTest
public class Test02인증메일발송 
{
	@Autowired
	private EmailService emailService;
	
	@Test
	public void test() 
	{
		emailService.sendCertNumber("nodvic89@gmail.com");
	}
}