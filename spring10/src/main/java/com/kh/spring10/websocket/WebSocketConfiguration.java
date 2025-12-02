package com.kh.spring10.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{

	//////////////////////////////
	// 웹소켓 붙이고도 서버 구동 성공을 위해 추가한 코드
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	registry.setApplicationDestinationPrefixes("/app"); // 발행 prefix
        registry.enableSimpleBroker("/public", "/private");     // 구독 prefix 공개/비공개
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
        .addEndpoint("/ws")
        .setAllowedOriginPatterns("*") // 접속 가능한 패턴 설정
        .withSockJS(); // 웹소켓 성능 향상(웹소켓을 HTTP처럼 쓰게 해줌)
    }
	//////////////////////////////
}
