package com.kh.spring10.websocket;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import com.kh.spring10.dao.RoomDao;
import com.kh.spring10.service.TokenService;
import com.kh.spring10.vo.TokenVO;
import com.kh.spring10.vo.websocket.WebSocketSystemMessageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebSocketEventHandler {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private TokenService tokenService;
	
	private Map<String, String> sessions = Collections.synchronizedMap(new HashMap<>());
	private Map<String, String> nicknames = Collections.synchronizedMap(new HashMap<>());
	
	@EventListener
	public void enter(SessionConnectEvent e) {
		log.debug("enter:"+UUID.randomUUID().toString());
		
		StompHeaderAccessor accessor=StompHeaderAccessor.wrap(e.getMessage());
		String roomNo = accessor.getFirstNativeHeader("roomNo");
		String accessToken = accessor.getFirstNativeHeader("accessToken");
		String refreshToken = accessor.getFirstNativeHeader("refreshToken");
		if(roomNo == null || accessToken == null || refreshToken == null) 
			return;//비회원은 진행 중지
		
		TokenVO tokenVO = tokenService.parse(accessToken);
		
		sessions.put(accessor.getSessionId(),  roomNo);
		nicknames.put(accessor.getSessionId(), tokenVO.getLoginId());
		
		simpMessagingTemplate.convertAndSend(
				"/public/group/"+roomNo+"/system", 
				WebSocketSystemMessageVO.builder()
					.type("system")
					.content("["+tokenVO.getLoginId()+"]님 입장")
					.time(LocalDateTime.now())
				.build()
		);
	}
	
	@EventListener
	public void leave(SessionConnectEvent e) {
		log.debug("leave:"+UUID.randomUUID().toString());
		

		StompHeaderAccessor accessor=StompHeaderAccessor.wrap(e.getMessage());
		String roomNo = sessions.remove(accessor.getSessionId());
		String loginId = nicknames.remove(accessor.getSessionId());
		
		simpMessagingTemplate.convertAndSend(
				"/public/group/"+roomNo+"/system", 
				WebSocketSystemMessageVO.builder()
					.type("system")
					.content("["+loginId+"]님 퇴장")
					.time(LocalDateTime.now())
				.build()
		);
	}
	
	@EventListener
	public void subscribe(SessionConnectEvent e) {
		log.debug("subscribe:"+UUID.randomUUID().toString());
	}
}
