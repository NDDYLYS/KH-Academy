package com.kh.spring10.service;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring10.configurtion.JwtProperties;
import com.kh.spring10.dao.AccountTokenDao;
import com.kh.spring10.dto.AccountDto;
import com.kh.spring10.dto.AccountTokenDto;
import com.kh.spring10.error.UnauthorizationException;
import com.kh.spring10.vo.TokenVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

//JWT 토큰의 생성 및 검사 등을 수행하는 서비스
@Service
public class TokenService {
	@Autowired
	private JwtProperties jwtProperties;
	
	@Autowired
	private AccountTokenDao accountTokenDao;
	
	/**
	 * 로그인한 사용자에게 향후 접근을 위한 액세스 토큰을 만드는 기능
	 */
	public String generateAccessToken(TokenVO tokenVO) 
	{
		return generateAccessToken(AccountDto.builder()
				.accountId(tokenVO.getLoginId())
				.accountLevel(tokenVO.getLoginLevel())
				.build());
	}
	
	public String generateAccessToken(AccountDto accountDto) {
		String keyStr = jwtProperties.getKeyStr();//설정파일에 있는 keyStr값
		SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));

		//만료시간 설정
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();//현재 시각
		c.add(Calendar.MINUTE, jwtProperties.getExpiration());
		Date expire = c.getTime();//만료 시각
		
		//JWT 토큰 생성
		return Jwts.builder()
				.signWith(key)//토큰 해독에 사용할 키 설정
				.expiration(expire)//토큰의 만료 시각 설정
				.issuedAt(now)//발행 시각 설정
				.issuer(jwtProperties.getIssuer())//발행자 (위변조 방지용)
				.claim("loginId", accountDto.getAccountId())//정보 추가(key,value)
				.claim("loginLevel", accountDto.getAccountLevel())//정보 추가(key,value)
			.compact();
	}
	
	public String generateRefreshToken(TokenVO tokenVO) 
	{
		return generateRefreshToken(AccountDto.builder()
				.accountId(tokenVO.getLoginId())
				.accountLevel(tokenVO.getLoginLevel())
				.build());
	}
	
	public String generateRefreshToken(AccountDto accountDto) {
		String keyStr = jwtProperties.getKeyStr();//설정파일에 있는 keyStr값
		SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));

		//만료시간 설정
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();//현재 시각
		//c.add(Calendar.MINUTE, 4 * 7 * 24 * 60);//4주
		//c.add(Calendar.DATE, 28);//4주
		c.add(Calendar.DATE, jwtProperties.getRefreshExpiration());
		Date expire = c.getTime();//만료 시각
		
		//JWT 토큰 생성
		String token = Jwts.builder()
				.signWith(key)//토큰 해독에 사용할 키 설정
				.expiration(expire)//토큰의 만료 시각 설정
				.issuedAt(now)//발행 시각 설정
				.issuer(jwtProperties.getIssuer())//발행자 (위변조 방지용)
				.claim("loginId", accountDto.getAccountId())//정보 추가(key,value)
				.claim("loginLevel", accountDto.getAccountLevel())//정보 추가(key,value)
			.compact();
		
		//DB 저장 (액세스 토큰과 달라지는 작업)
		accountTokenDao.insert(AccountTokenDto.builder()
					.accountTokenTarget(accountDto.getAccountId())//누구에게
					.accountTokenValue(token)//무슨토큰을 발행했는지
				.build());
		
		//토큰 반환
		return token;
	}

	public TokenVO parse(String authorization) {
		if(authorization.startsWith("Bearer ") == false)//Bearer 토큰이 아니라면
			throw new UnauthorizationException();//예외 처리!
		
		//앞 7글자 제거 (B.e.a.r.e.r. )
		//String token = authorization.substring("Bearer ".length());
		String token = authorization.substring(7);
		
		SecretKey key = Keys.hmacShaKeyFor(jwtProperties.getKeyStr().getBytes(StandardCharsets.UTF_8));
		Claims claims = (Claims) Jwts.parser()
				.verifyWith(key)
				.requireIssuer(jwtProperties.getIssuer())
			.build()
				.parse(token)
				.getPayload();
		//claims에 담긴 데이터를 TokenVO에 옮겨담아서 반환
		return TokenVO.builder()
					.loginId((String)claims.get("loginId"))
					.loginLevel((String)claims.get("loginLevel"))
				.build();
	}
	
	//JWT 토큰의 만료까지 남은시간을 구하는 기능
	public long getRemain(String bearerToken) {
		if(bearerToken.startsWith("Bearer ") == false)//Bearer 토큰이 아니라면
			throw new UnauthorizationException();//예외 처리!
		
//		if (bearerToken == null || bearerToken.isBlank()) {
//	        throw new UnauthorizationException("Authorization header missing");
//	    }
//
//	    if (!bearerToken.startsWith("Bearer ")) {
//	        throw new UnauthorizationException("Invalid token type");
//	    }
		
		//앞 7글자 제거 (B.e.a.r.e.r. )
		String token = bearerToken.substring(7);
		
		SecretKey key = Keys.hmacShaKeyFor(jwtProperties.getKeyStr().getBytes(StandardCharsets.UTF_8));
		Claims claims = (Claims) Jwts.parser()
				.verifyWith(key)
				.requireIssuer(jwtProperties.getIssuer())
			.build()
				.parse(token)
				.getPayload();
		
		Date expire = claims.getExpiration();//만료시각 추출
		//return expire.getTime() - System.currentTimeMillis();//만료시각 - 현재시각
		Date now = new Date();
		return expire.getTime() - now.getTime();//만료시각 - 현재시각 (무조건 0이상)
	}
	
	public boolean checkRefreshToken(TokenVO tokenVO, String refreshToken) 
	{
		AccountTokenDto accountTokenDto = accountTokenDao.selectOne(AccountTokenDto.builder()
				.accountTokenTarget(tokenVO.getLoginId())
				.accountTokenValue(refreshToken)
				.build());
		
		if (accountTokenDto == null) return false;
		
		accountTokenDao.delete(accountTokenDto.getAccountTokenNo());
		
		return true;
	}
}