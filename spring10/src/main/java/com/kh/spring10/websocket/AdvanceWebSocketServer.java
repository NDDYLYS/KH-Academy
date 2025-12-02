package com.kh.spring10.websocket;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdvanceWebSocketServer {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/advance")
	public void advance(Message<WebSocketAdvanceRequestVO> message) {
		WebSocketAdvanceRequestVO requestVO = message.getPayload();
		
		String regex = "(십일|십이|십삼|십사|십오)";
		String filteredStr = requestVO.getContent().replaceAll(regex, "***");
		
		WebSocketAdvanceResponseVO responseVO = WebSocketAdvanceResponseVO.builder()
				.content(filteredStr)
				.time(LocalDateTime.now())
				.build();
		
		simpMessagingTemplate.convertAndSend("/public/advance", responseVO);
	}
}
