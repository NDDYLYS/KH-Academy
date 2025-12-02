package com.kh.spring10.websocket;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.kh.spring10.service.TokenService;
import com.kh.spring10.vo.TokenVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberOnlyWebSocketServer {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private TokenService tokenService;
	
	@MessageMapping("/member")//이 주소는 /app/member
	public void member(Message<WebSocketMemberRequestVO> message) {
		//[1] 사용자가 보낸 메세지에서 토큰 관련 헤더를 꺼낸다
		// - 비회원은 없다는 사실이 중요함
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		String accessToken = accessor.getFirstNativeHeader("accessToken");
		String refreshToken = accessor.getFirstNativeHeader("refreshToken");
		if(accessToken == null || refreshToken == null) return;//비회원은 진행 중지
		
		//[2] 회원이 보낸 메세지를 확인하고 토큰을 해석해서 상황에 맞는 처리를 수행
		//- 토큰이 만료되거나 기타 등의 사유로 갱신이 필요하다면 개인메세지를 발송해야함
		//- 채널 : /private/token/{id}
		try {
			TokenVO tokenVO;
			try {//Plan A : 토큰이 멀쩡한 경우
				tokenVO = tokenService.parse(accessToken);
			}
			catch(Exception e) {//Plan B : 토큰이 이상한 경우
				tokenVO = tokenService.parse(refreshToken);
				//DB에 존재하는 토큰인지 검사 후 재발급 처리
			}
			//메세지 추출
			WebSocketMemberRequestVO requestVO = message.getPayload();
			
			//[3] 욕설이 포함된 경우는 Advance처럼 경고메세지를 발송
			//- 개인메세지로 발송되며 채널은 [2]와 달라야 함
			//- 채널 : /private/warning/{id}
			
			//[4] 일반 메세지는 필요한 정보를 추가하여 발송
			//- 채널 : /public/member
			simpMessagingTemplate.convertAndSend(
					"/public/member", 
					WebSocketMemberResponseVO.builder()
						.loginId(tokenVO.getLoginId())//발신자ID
						.loginLevel(tokenVO.getLoginLevel())//발신자회원등급
						.content(requestVO.getContent())//보낸내용
						.time(LocalDateTime.now())//시간
					.build()
			);
		}
		catch(Exception e) {//Plan C : 리프레시토큰마저 이상한경우
			//더 이상 할 필요가 없거나 사용자에게 에러 메세지를 전송
		}
	}
}