package com.kh.spring10.configurtion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @ConfigurationProperties(prefix="custom.publicdata")
public class PublicDataProperties {
	private String key;
}