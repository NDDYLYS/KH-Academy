package com.kh.spring10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Spring10Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring10Application.class, args);
	}

}
