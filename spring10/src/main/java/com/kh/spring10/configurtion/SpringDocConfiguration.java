package com.kh.spring10.configurtion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocConfiguration {

	@Bean
	public OpenAPI info() {
		Info info = new Info();
		info.setVersion("0.0.1");
		info.setTitle("KH 정보교육원 수업용 REST API");
		info.setDescription("ReactJS와 통신");
		
		return new OpenAPI().info(info);
	}
}
