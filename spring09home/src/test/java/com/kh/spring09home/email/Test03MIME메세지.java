package com.kh.spring09home.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03MIME메세지 
{	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException 
	{
		// 우리가 원하는 형태의 내용을 메일에 담아서 전송하도록 마임메세지를 생성
		// MIMEMessage message = new MIMEMessage();
		// 마임메세지를 sender와 연결하여 생성
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setTo(new String[] {"nodvic89@gmail.com"});
		helper.setSubject("제목");
		helper.setText("<h1>내용</h1>", true);
		
		sender.send(message);
	}
}
