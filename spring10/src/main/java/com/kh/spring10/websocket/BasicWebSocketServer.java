package com.kh.spring10.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BasicWebSocketServer {

	@MessageMapping("/basic")
	@SendTo("/public/basic")
	public String basic(String message) {
		//log.debug("message={}", message);
		
		return message;
	}
}
