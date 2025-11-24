package com.kh.spring10.service;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring10.configurtion.JwtProperties;
import com.kh.spring10.dto.AccountDto;
import com.kh.spring10.error.UnauthorizationException;
import com.kh.spring10.vo.TokenVO;

import io.jsonwebtoken.Claims;
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
		
		c.add(Calendar.MINUTE, 1);
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
	
	public TokenVO parse(String authorization) {
		if (authorization.startsWith("Bearer ") == false)
			throw new UnauthorizationException("토큰을 조작했다.");
		
		String token = authorization.substring(7);
		SecretKey key = Keys.hmacShaKeyFor(jwtProperties.getKeyStr().getBytes(StandardCharsets.UTF_8));
		
		Claims claims =  (Claims) Jwts.parser()
				.verifyWith(key)
				.requireIssuer(jwtProperties.getIssuer())
				.build()
				.parse(token)
				.getPayload();
		
		return TokenVO.builder()
				.loginId((String)claims.get("loginId"))
				.loginLevel((String)claims.get("loginLevel"))
				.build();
	}
}