package com.kh.spring09home.email;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
public class Test02단문메일발송 
{
	@Autowired
	private JavaMailSenderImpl sender;
	
	@Test
	public void test() 
	{
		//3.메세지 객체 생성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("nodvic89@gmail.com");
		//message.setCc(null); cc : Carbon Copy
		//message.setBCc(null); bcc : Blind Carbon Copy
		message.setSubject("테스트 제목입니다22222.");
		message.setText("테스트 내용입니다22222.");
		
		//4.메세지 전송
		sender.send(message);
	}
}