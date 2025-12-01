package com.kh.spring10.configurtion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PublicDataConfiguration {
	@Bean(name = "publicdataWebClient")
	public WebClient webClient() {
		return WebClient.builder()
				.baseUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst")//시작주소 지정
			.build();
	}
}