package com.kh.spring10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring10.dao.MessageDao;
import com.kh.spring10.dto.MessageDto;
import com.kh.spring10.vo.TokenVO;
import com.kh.spring10.vo.websocket.WebSocketGroupRequestVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GroupChatService {
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate; 
	
	@Transactional
	public void sendChat(long roomNo, WebSocketGroupRequestVO requestVO, TokenVO tokenVO) 
	{
		//DB저장
		MessageDto messageDto = messageDao.insert(MessageDto.builder()
					.messageRoom(roomNo)
					.messageType("chat")
					.messageContent(requestVO.getContent())
					.messageSender(tokenVO.getLoginId())
				.build());
		//전송
		
		//[4] 일반 메세지는 필요한 정보를 추가하여 발송
		//- 채널 : /public/group/방번호
		simpMessagingTemplate.convertAndSend(
				"/public/group/"+roomNo, messageDto);
	}
}
