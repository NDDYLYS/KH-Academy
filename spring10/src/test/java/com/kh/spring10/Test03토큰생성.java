package com.kh.spring10;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

// JWT (Java Web Token) : jjwt-api, jjwt-jackson, jjwt-impl
@SpringBootTest
public class Test03토큰생성 {

	@Test
	public void test() {
		// 1. 위변조 확인을 위해 나만 알 수 있는 식별키 생성 (32글자 이상)
		String keyStr = "nodvicdkzkepal12#nodvicdkzkepal12#nodvicdkzkepal12#";
		SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
		
		// 2. 토큰은 영원하 유효하지 않기에 시간을 설정
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();
		
		c.add(Calendar.MINUTE, 30);
		Date expire = c.getTime();
		
		// 3. 토큰 생성
		String token = Jwts.builder()
				.signWith(key)
				.expiration(expire)
				.issuedAt(now)
				.issuer("KH정보교육원")
				.claim("loginId", "testuser1")
				.claim("loginLevel", "일반회원")
				.compact();
		
		// 4. 확인
		System.out.println(token);
	}
}