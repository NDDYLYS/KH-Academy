package com.kh.spring10.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MessageDto {
	private int messageNo;
	private String messageType;
	private int messageRoom;
	private String messageSender;
	private String messageContent;
	private LocalDateTime messageTime;
}
