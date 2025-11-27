package com.kh.spring10.kakaopay;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring10.service.KakaoPayService;
import com.kh.spring10.vo.KakaoPayReadyRequestVO;
import com.kh.spring10.vo.KakaoPayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test03결제모듈화 {
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() {
		KakaoPayReadyRequestVO requestVO = KakaoPayReadyRequestVO.builder()
				.partnerOrderId(UUID.randomUUID().toString())
				.partnerUserId("nodvic")
				.itemName("사탕")
				.totalAmount(300)
				.build();
		
		KakaoPayReadyResponseVO responseVO = kakaoPayService.ready(requestVO);
		
		log.debug("request = {}", requestVO);
		log.debug("response = {}", responseVO);
	}
}
