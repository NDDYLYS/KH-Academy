package com.kh.spring09home.email;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
public class Test01단문메일발송 
{
	@Test
	public void test() 
	{
		//1.이메일 전송 도구 준비
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		//2.사용할 서비스 정보 입력
		// 수신자, 참조자, 제목
		sender.setHost("smtp.gmail.com");
		sender.setPort(587); // 구글의 사용 포트
		// http의 기본 포트:80
		// https의 기본 포트:443		
		sender.setUsername("nodvicsemi");
		sender.setPassword("zxhiobqclqvkctqw");
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.debug", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		sender.setJavaMailProperties(props);
		
		//3.메세지 객체 생성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("nodvic89@gmail.com");
		//message.setCc(null); cc : Carbon Copy
		//message.setBCc(null); bcc : Blind Carbon Copy
		message.setSubject("테스트 제목입니다.");
		message.setText("테스트 내용입니다.");
		
		//4.메세지 전송
		sender.send(message);
	}
}