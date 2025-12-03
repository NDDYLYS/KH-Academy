package com.kh.spring10.websocket;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.kh.spring10.configurtion.JwtProperties;
import com.kh.spring10.service.TokenService;
import com.kh.spring10.vo.TokenVO;
import com.kh.spring10.vo.websocket.WebSocketGroupRequestVO;
import com.kh.spring10.vo.websocket.WebSocketGroupResponseVO;
import com.kh.spring10.vo.websocket.WebSocketSystemMessageVO;
import com.kh.spring10.vo.websocket.WebSocketTokenRefreshVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GroupWebSocketServer {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private JwtProperties jwtProperties;
	
	//이 서버는 채널명에 변수(방번호)가 존재한다
	// - 웹에서의 경로변수와 유사하지만 통신방식이 다르므로 받는방법이 다름
	// - @GetMapping 대신 @MessageMapping 사용
	// - @PathVariable 대신 @DestinationVariable 사용
	@MessageMapping("/group/{roomNo}")
	public void group(@DestinationVariable long roomNo,
					Message<WebSocketGroupRequestVO> message) {
		//[1] 사용자가 보낸 메세지에서 토큰 관련 헤더를 꺼낸다
		// - 비회원은 없다는 사실이 중요함
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		String accessToken = accessor.getFirstNativeHeader("accessToken");
		String refreshToken = accessor.getFirstNativeHeader("refreshToken");
		if(accessToken == null || refreshToken == null) return;//비회원은 진행 중지
		
		//[2] 회원이 보낸 메세지를 확인하고 토큰을 해석해서 상황에 맞는 처리를 수행
		//- 토큰이 만료되거나 기타 등의 사유로 갱신이 필요하다면 개인메세지를 발송해야함
		try {
			TokenVO tokenVO;
			try {//Plan A : 토큰이 멀쩡한 경우
				tokenVO = tokenService.parse(accessToken);
				//TokenRenewalInterceptor에 있는 갱신코드와 동일한 코드 사용
				long ms = tokenService.getRemain(accessToken);
				if(ms >= jwtProperties.getRenewalLimit() * 60L * 1000L) {
					simpMessagingTemplate.convertAndSend(
							"/private/group/"+roomNo+"/token/"+tokenVO.getLoginId(), 
							WebSocketTokenRefreshVO.builder()
								.accessToken(tokenService.generateAccessToken(tokenVO))
								.refreshToken(tokenService.generateRefreshToken(tokenVO))
							.build()
					);
				}
			}
			catch(Exception e) {//Plan B : 토큰이 이상한 경우
				tokenVO = tokenService.parse(refreshToken);
				//DB에 존재하는 토큰인지 검사 후 재발급 처리
				if(tokenService.checkRefreshToken(tokenVO, refreshToken) == false) {
					throw new Exception();//Plan C로 가라!
				}
				//사용자에게 토큰 갱신이 필요하다고 알려줘야함 (/private/token/아이디)
				simpMessagingTemplate.convertAndSend(
						"/private/group/"+roomNo+"/token/"+tokenVO.getLoginId(), 
						WebSocketTokenRefreshVO.builder()
							.accessToken(tokenService.generateAccessToken(tokenVO))
							.refreshToken(tokenService.generateRefreshToken(tokenVO))
						.build()
				);
			}
			//메세지 추출
			WebSocketGroupRequestVO requestVO = message.getPayload();
			
			//[3] 욕설이 포함된 경우는 Advance처럼 경고메세지를 발송
			//- 개인메세지로 발송되며 채널은 [2]와 달라야 함
			//- (참고) Matcher는 특정 패턴의 위치를 찾는 도구 (indexOf 정규표현식 버전 느낌)
			String regex = "(십장생|십자수|시베리아|수박씨|신발끈|개나리)";
			Matcher matcher = Pattern.compile(regex).matcher(requestVO.getContent());
			if(matcher.find()) {//찾았어? while로 작성하면 안나올때까지 찾음
				log.debug("욕설이 감지됨");
				simpMessagingTemplate.convertAndSend(
						"/private/group/"+roomNo+"/warning/"+tokenVO.getLoginId(), //채널명
						WebSocketSystemMessageVO.builder()
							.type("warning")
							.content("욕설은 사용하실 수 없습니다")
							.time(LocalDateTime.now())
						.build()
				);
				return;
			}
			
			//[4] 일반 메세지는 필요한 정보를 추가하여 발송
			//- 채널 : /public/group/방번호
			simpMessagingTemplate.convertAndSend(
					"/public/group/"+roomNo, 
					WebSocketGroupResponseVO.builder()
						.loginId(tokenVO.getLoginId())//발신자ID
						.loginLevel(tokenVO.getLoginLevel())//발신자회원등급
						.content(requestVO.getContent())//보낸내용
						.time(LocalDateTime.now())//시간
					.build()
			);
		}
		catch(Exception e) {//Plan C : 리프레시토큰마저 이상한경우
			//더 이상 아무것도 할 필요가 없다
		}
	}
}