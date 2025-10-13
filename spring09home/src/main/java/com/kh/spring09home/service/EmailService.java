package com.kh.spring09home.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring09home.dao.CertDao;
import com.kh.spring09home.dto.CertDto;
import com.kh.spring09home.dto.MemberDto;

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
	
	public void sendWelcomeMail(MemberDto memberDto) throws MessagingException, IOException 
	{
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setTo(new String[] {memberDto.getMemberEmail()});
		helper.setSubject("가입을 축하합니다.");
		
		ClassPathResource resource = new ClassPathResource("templates/welcome2.html");
		File target = resource.getFile();
		
		StringBuffer buffer = new StringBuffer();
		
		BufferedReader reader = new BufferedReader(new FileReader(target));
		while(true) {
			String line = reader.readLine();
			if(line == null) break;
			buffer.append(line);
		}
		reader.close();
		
		// jsoup 사용 전 코드
		//helper.setText(buffer.toString(), true);
		// jsoup 사용 후 코드
		// $("#target").text("???") jQuery 감성
		// $("#link").attr("href", "주소") jQuery 감성
		
		
		Document document = Jsoup.parse(buffer.toString());//String을 HTML로 해석
		Element targetId = document.selectFirst("#target");//id=target인 대상을 탐색
		Element targetLink = document.selectFirst("#link");//id=link인 대상을 탐색
		targetId.text(memberDto.getMemberNickname());//textContent변경
		
		String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/").build().toUriString();
		targetLink.attr("href", url);//attribute 변경
		
		helper.setText(document.toString(), true);//HTML로 해석된 내용을 본문으로 설정
		
		sender.send(message);
	}
}
