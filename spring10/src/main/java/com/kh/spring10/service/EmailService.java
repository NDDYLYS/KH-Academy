package com.kh.spring10.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.server.PathContainer.Element;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.kh.spring10.dao.CertDao;
import com.kh.spring10.dto.AccountDto;
import com.kh.spring10.dto.CertDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService 
{
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private CertDao certDao;
	
	public void sendEmail(String to, String subject, String text) 
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		sender.send(message);
	}
	
	public void sendCertNumber(String email) 
	{
		Random r = new Random();
		int number = r.nextInt(1000000);
		DecimalFormat df = new DecimalFormat("000000");
		String certNumber = df.format(number);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[KH정보과학교육원]에서 발송한 인증메일입니다.");
		message.setText("[KH정보과학교육원]에서 발송한 인증메일입니다. 인증번호는 ["+certNumber+"]입니다.");
		sender.send(message);
		
		// 인증번호를 DB에 저장하는 코드
		CertDto certDto = certDao.selectOne(email);
		if (certDto == null) 
		{			
			certDao.insert(CertDto.builder().certEmail(email).certNumber(certNumber).build());
		}
		else 
		{
			certDao.update(CertDto.builder().certEmail(email).certNumber(certNumber).build());			
		}
	}
}
