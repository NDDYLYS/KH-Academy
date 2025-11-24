package com.kh.spring10;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@SpringBootTest
public class Test04토큰검사 {

	@Test
	public void test() {
		// 1.토큰 준비
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJleHAiOjE3NjM5NTE2MDQsImlhdCI6MTc2Mzk0OTgwNCwiaXNzIjoiS0jsoJXrs7TqtZDsnKHsm5AiLCJsb2dpbklkIjoidGVzdHVzZXIxIiwibG9naW5MZXZlbCI6IuydvOuwmO2ajOybkCJ9.-wy1Tnw7z_WkWHCK1sYwmQBPGGO_gmVeOlvDKg0QaaQ9c9z0yeYZFh0G_vjrVwaP";
		
		// 2.해석을 위한 열쇠 생성
		String keyStr = "nodvicdkzkepal12#nodvicdkzkepal12#nodvicdkzkepal12#";
		SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
		
		// 3.토큰해석
		Claims claims = (Claims) Jwts.parser()
				.verifyWith(key)
				.requireIssuer("KH정보교육원")
				.build()
				.parse(token)
				.getPayload();
		
		// 4.정보출력
		String loginId = (String)claims.get("loginId");
		String loginLevel = (String)claims.get("loginLevel");
		
		System.out.println("loginId:" +loginId);
		System.out.println("loginLevel:" +loginLevel);
	}
}
