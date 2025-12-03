package com.kh.spring10.websocket;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.kh.spring10.vo.websocket.WebSocketAdvanceRequestVO;
import com.kh.spring10.vo.websocket.WebSocketAdvanceResponseVO;
import com.kh.spring10.vo.websocket.WebSocketSystemMessageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdvanceWebSocketServer {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	//Message
	//- STOMP 형태의 채팅에서 사용자가 보낸 메세지의 종합적인 정보를 가지는 객체
	//- Header, Body 등
	//- Generic type 지정을 권장
	@MessageMapping("/advance")
	public void advance(Message<WebSocketAdvanceRequestVO> message) {
		//(+추가) 사용자가 보낸 메세지에 포함된 헤더(uuid)를 추출.. 여차하면 개인메세지 전송
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		String uuid = accessor.getFirstNativeHeader("uuid");//해당되는 첫번째 헤더 읽기
		log.debug("UUID = {}", uuid);
		
		//사용자가 보낸 내용을 추출
		WebSocketAdvanceRequestVO requestVO = message.getPayload();
		
		//(+추가) 간단한 욕설을 마스킹 처리
		//String regex = "(십장생|십자수|시베리아|수박씨|신발끈|개나리)";
		//String filteredStr = requestVO.getContent().replaceAll(regex, "***");
		
		//(+추가) 욕설을 할 경우 개인 채널에 시스템메세지를 전송
		String regex = "(.*?)(십장생|십자수|시베리아|수박씨|신발끈|개나리)(.*?)";
		if(requestVO.getContent().matches(regex)) {
			log.debug("욕설이 감지됨");
			simpMessagingTemplate.convertAndSend(
					"/private/advance/"+uuid, //채널명
					WebSocketSystemMessageVO.builder()
						.type("warning")
						.content("욕설은 사용하실 수 없습니다")
						.time(LocalDateTime.now())
					.build()
			);
			return;
		}
		
		//서버가 사용자에게 보낼 메세지를 생성
		WebSocketAdvanceResponseVO responseVO = 
						WebSocketAdvanceResponseVO.builder()
							.sender(uuid)
							.content(requestVO.getContent())//메세지 내용
							.time(LocalDateTime.now())//현재시각
						.build();
		
		simpMessagingTemplate.convertAndSend("/public/advance", responseVO);
	}
}
