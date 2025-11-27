package com.kh.spring10.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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
	private WebClient webClient;
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
		
		KakaoPayReadyResponseVO response = webClient.post()
				.uri("/online/v1/payment/ready") // .uri("open-api.kakaopay.com/online/v1/payment/ready")
				.bodyValue(body)
				.retrieve()
				.bodyToMono(KakaoPayReadyResponseVO.class)
				.block();
		
		return response;
	}
	
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO responseVO) 
	{
		Map<String, String> body = new HashMap<>();
		//body에 필요한 정보들을 담음 (카카오페이 문서 확인)
		body.put("cid", kakaoPayProperties.getCid());
		body.put("partner_order_id", responseVO.getPartnerOrderId());
		body.put("partner_user_id", responseVO.getPartnerUserId());
		body.put("tid", responseVO.getTid());
		body.put("pg_token", responseVO.getPgToken());
		
		KakaoPayApproveResponseVO response = webClient.post()//POST 요청
				.uri("/online/v1/payment/approve")//webClient에 기본주소 설정이 있을 경우
				.bodyValue(body)//요청에 첨부할 데이터 설정
			.retrieve()//응답을 수신하겠다
				.bodyToMono(KakaoPayApproveResponseVO.class)//데이터는 한번에 오고(Mono) 형태는 Map이다 (↔ 연속적으로 오면 Flux)
				.block();//동기적으로 변환하여 응답이 올때까지 기다려라! (RestTemplate과 같아짐)
		
		return response;
	}
}
