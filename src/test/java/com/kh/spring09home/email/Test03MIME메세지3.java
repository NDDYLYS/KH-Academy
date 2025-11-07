package com.kh.spring09home.email;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03MIME메세지3 
{	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException, IOException 
	{
		// 우리가 원하는 형태의 내용을 메일에 담아서 전송하도록 마임메세지를 생성
		// MIMEMessage message = new MIMEMessage();
		// 마임메세지를 sender와 연결하여 생성
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setTo(new String[] {"nodvic89@gmail.com"});
		helper.setSubject("제목");
		
		
		// 미리 만들어둔 파일을 불러와서 전송
		// classpath : src 내부 경로
		// filepath : 프로젝트 내부의 경로
		ClassPathResource resource = new ClassPathResource("templates/welcome.html");
		File target = resource.getFile();
		
		StringBuffer buffer = new StringBuffer();
		
		BufferedReader reader = new BufferedReader(new FileReader(target));
		while(true) {
			String line = reader.readLine();
			if(line == null) break;
			buffer.append(line);
		}
		reader.close();
		
		//		Scanner sc = new Scanner(target);
		//		while(sc.hasNextLine()) 
		//		{
		//			buffer.append(sc.nextLine());
		//		}
		
		helper.setText(buffer.toString(), true);
		
		sender.send(message);
	}
}
