package com.kh.spring10.service;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring10.configurtion.JwtProperties;
import com.kh.spring10.dto.AccountDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {
	@Autowired
	private JwtProperties jwtProperties;
	
	public String generateAccessToken(AccountDto accountDto) {
		String keyStr = jwtProperties.getKeyStr();
		SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
		
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();
		
		c.add(Calendar.MINUTE, 30);
		Date expire = c.getTime();
		
		String token = Jwts.builder()
				.signWith(key)
				.expiration(expire)
				.issuedAt(now)
				.issuer(jwtProperties.getIssuer())
				.claim("loginId", accountDto.getAccountId())
				.claim("loginLevel", accountDto.getAccountLevel())
				.compact();
		
		//System.out.println(token);
		return token;
	}
}