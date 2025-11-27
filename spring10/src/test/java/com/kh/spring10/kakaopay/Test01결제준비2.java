package com.kh.spring10.kakaopay;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01결제준비2 {
	
	@Test
	public void test() {
		String itemName = "5000Point 충전권";
		int totalAmount = 4500;
		String partnerOrderId = UUID.randomUUID().toString();
		String partnerUserId = "testuser1";
		
		// WebClient 준비
		WebClient webClient = WebClient.builder()
				.baseUrl("https://open-api.kakaopay.com")
				.defaultHeader("Authorization", "SECRET_KEY DEV25BA6B13CDE0C5DEEC54B4E3569B4BBB47ED4")
				.defaultHeader("Content-Type", "application/json")
				.build();
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", "TC0ONETIME");
		body.put("partner_order_id", partnerOrderId);
		body.put("partner_user_id", partnerUserId);
		body.put("item_name", itemName);
		body.put("quantity", "1");
		body.put("total_amount", String.valueOf(totalAmount));
		body.put("tax_free_amount", "0");
		body.put("approval_url", "http://localhost:8080/success");
		body.put("cancel_url", "http://localhost:8080/cancel");
		body.put("fail_url", "http://localhost:8080/fail");
		
		Map response = webClient.post()
				.uri("/online/v1/payment/ready") // .uri("open-api.kakaopay.com/online/v1/payment/ready")
				.bodyValue(body)
				.retrieve()
				.bodyToMono(Map.class)
				.block();
		
		
		log.debug("partner_order_id = {}", partnerOrderId);
		log.debug("partner_user_id = {}", partnerUserId);
		for(Object name : response.keySet()) {
			Object value = response.get(name);
			log.debug("{} = {}", name, value);
		}
		
		//body.put("", "");
	}
}



//package com.kh.spring10.kakaopay;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class Test01결제준비 {
//	
//	@Test
//	public void test() {
//		
//	}
//}
