package com.kh.spring10.configurtion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @ConfigurationProperties(prefix="custom.kakaopay")
public class KakaoPayProperties {
	private String cid; // custom.jwt.key-Str을 불러온다
	private String secretKey;
}