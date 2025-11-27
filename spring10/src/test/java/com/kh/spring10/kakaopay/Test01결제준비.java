package com.kh.spring10.kakaopay;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class Test01결제준비 {
	
	@Test
	public void test() {
		// WebClient 준비
		WebClient webClient = WebClient.builder()
				.baseUrl("https://open-api.kakaopay.com")
				.defaultHeader("Authorization", "SECRET_KEY DEV25BA6B13CDE0C5DEEC54B4E3569B4BBB47ED4")
				.defaultHeader("Content-Type", "application/json")
				.build();
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", "TC0ONETIME");
		body.put("partner_order_id", UUID.randomUUID().toString());
		body.put("partner_user_id", "testuser1");
		body.put("item_name", "5000Point 충전권");
		body.put("quantity", "1");
		body.put("total_amount", "4500");
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
