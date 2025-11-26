package com.kh.spring10.configurtion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfiguration {

	@Bean
	public OpenAPI info() {
		Info info = new Info();
		info.setVersion("0.0.1");
		info.setTitle("KH 정보교육원 수업용 REST API");
		info.setDescription("ReactJS와 통신");
		
		// 추가 JWT 인증방식 적용, 이를 반영
		String jwtHeaderName = "Authorization";
		SecurityRequirement requirement = new SecurityRequirement();
		requirement.addList(jwtHeaderName);
		
		Components components = new Components();
		components.addSecuritySchemes(jwtHeaderName, 
				new SecurityScheme().name(jwtHeaderName)
				.type(SecurityScheme.Type.HTTP).scheme("bearer"));
		
		
		return new OpenAPI().info(info).addSecurityItem(requirement).components(components);
	}
}
