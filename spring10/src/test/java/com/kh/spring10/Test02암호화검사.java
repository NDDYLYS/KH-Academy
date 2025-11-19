//package com.kh.spring10;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//public class Test02암호화검사 {
//
//	@Test
//	public void test() {
//	
//		String pw = "$2a$10$EG8P9Q5ebDe3638xyiNideABTP5IKfaZ8vyzhA1wWEVROM4efnit2";
//				
//		String password = "Testuser33!";
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		
//		System.out.println(encoder.matches(password, pw));
//	}
//	
//}
