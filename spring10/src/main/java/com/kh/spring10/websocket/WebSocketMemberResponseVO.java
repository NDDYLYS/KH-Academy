package com.kh.spring10.websocket;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class WebSocketMemberResponseVO {
	@Builder.Default
	private String type = "chat";//유형
	private String loginId;//발신자ID
	private String loginLevel;//발신자등급
	private String content;//본문
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime time;//보낸시간
}

