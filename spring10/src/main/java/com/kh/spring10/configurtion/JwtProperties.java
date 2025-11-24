package com.kh.spring10.configurtion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @ConfigurationProperties(prefix="custom.jwt")
public class JwtProperties {
	private String keyStr; // custom.jwt.key-Str을 불러온다
	private String issuer;
}