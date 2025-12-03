package com.kh.spring10.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.RoomDao;
import com.kh.spring10.dto.RoomDto;
import com.kh.spring10.vo.TokenVO;
import com.kh.spring10.websocket.RoomEnterVO;

@CrossOrigin
@RestController
@RequestMapping("/room")
public class RoomRestController {
	@Autowired
	private RoomDao roomDao;
	
	@PostMapping("/")
	public RoomDto create(@RequestBody RoomDto roomDto,
									@RequestAttribute TokenVO tokenVO) {
		//방 생성을 하면 대상을 입장까지 시켜야 한다
		RoomDto resultDto = roomDao.insert(roomDto);
		roomDao.enter(resultDto.getRoomNo(), tokenVO.getLoginId());
		return resultDto;
	}
	@GetMapping("/")
	public List<RoomEnterVO> list(@RequestAttribute TokenVO tokenVO) {
		return roomDao.selectList(tokenVO.getLoginId());
	}
	@GetMapping("/list")
	public List<RoomDto> list() {
		return roomDao.selectList();
	}
	@GetMapping("/{roomNo}")
	public RoomDto detail(@PathVariable long roomNo) {
		return roomDao.selectOne(roomNo);
	}
}