//package com.kh.spring10;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//public class Test01단방향암호화 {
//
//	@Test
//	public void test() {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		
//		String password = "Testuser33!";
//		String result = encoder.encode(password);
//		
//		System.out.println(result);
//		System.out.println(result.length());
//	
//	}
//	
//}
