package com.kh.spring10.kakaopay;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@SpringBootTest
public class Test02결제승인 {

	@Test
	public void test() {
		String partnerOrderId = "00e5a9af-6b4c-4a79-bc23-431bec01f548";
		String partnerUserId = "testuser1";
		String pgToken = "91b9599d856411855a16";
		String tid = "T9280495299c193d827b";
		
		//WebClient 준비
		WebClient webClient = WebClient.builder()
				.baseUrl("https://open-api.kakaopay.com")
				.defaultHeader("Authorization", "SECRET_KEY DEV25BA6B13CDE0C5DEEC54B4E3569B4BBB47ED4")
				.defaultHeader("Content-Type", "application/json")
				.build();
		
		Map<String, String> body = new HashMap<>();
		//body에 필요한 정보들을 담음 (카카오페이 문서 확인)
		body.put("cid", "TC0ONETIME");
		body.put("partner_order_id", partnerOrderId);
		body.put("partner_user_id", partnerUserId);
		body.put("tid", tid);
		body.put("pg_token", pgToken);
		
		Map response = webClient.post()//POST 요청
				.uri("/online/v1/payment/approve")//webClient에 기본주소 설정이 있을 경우
				.bodyValue(body)//요청에 첨부할 데이터 설정
			.retrieve()//응답을 수신하겠다
				.bodyToMono(Map.class)//데이터는 한번에 오고(Mono) 형태는 Map이다 (↔ 연속적으로 오면 Flux)
				.block();//동기적으로 변환하여 응답이 올때까지 기다려라! (RestTemplate과 같아짐)
		
		for(Object name : response.keySet()) {
			Object value = response.get(name);
			log.debug("{} = {}", name, value);
		}
	}
}
