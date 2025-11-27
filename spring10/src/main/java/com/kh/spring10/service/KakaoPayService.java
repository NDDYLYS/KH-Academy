package com.kh.spring10.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring10.configurtion.KakaoPayConfiguration;
import com.kh.spring10.configurtion.KakaoPayProperties;
import com.kh.spring10.vo.KakaoPayApproveRequestVO;
import com.kh.spring10.vo.KakaoPayApproveResponseVO;
import com.kh.spring10.vo.KakaoPayReadyRequestVO;
import com.kh.spring10.vo.KakaoPayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaoPayService {
	@Autowired
	private KakaoPayConfiguration kakaoPayConfiguration;
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	public KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO requestVO) {
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("partner_order_id", requestVO.getPartnerOrderId());
		body.put("partner_user_id", requestVO.getPartnerUserId());
		body.put("item_name", requestVO.getItemName());
		body.put("quantity", "1");
		body.put("total_amount", String.valueOf(requestVO.getTotalAmount()));
		body.put("tax_free_amount", "0");
		body.put("approval_url", "http://localhost:8080/success");
		body.put("cancel_url", "http://localhost:8080/cancel");
		body.put("fail_url", "http://localhost:8080/fail");
		
		KakaoPayReadyResponseVO response = kakaoPayConfiguration.WebClient().post()
				.uri("/online/v1/payment/ready") // .uri("open-api.kakaopay.com/online/v1/payment/ready")
				.bodyValue(body)
				.retrieve()
				.bodyToMono(KakaoPayReadyResponseVO.class)
				.block();
		
		return response;
	}
	
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO responseVO) {
		
	}
}
