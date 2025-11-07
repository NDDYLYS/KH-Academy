package com.kh.spring09home.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfiguration 
{
	// 스프링 서버가 시작되면 @Bean을 찾아서 자동으로 등록하도록 설계되어 있다
	@Bean
	public JavaMailSenderImpl sender() 
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
		
		return sender;
	}
}
