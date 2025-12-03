package com.kh.spring10.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.RoomDto;
import com.kh.spring10.error.TargetNotfoundException;
import com.kh.spring10.vo.websocket.RoomEnterVO;

@Repository
public class RoomDao {
	@Autowired
	private SqlSession sqlSession;
	
//	public long sequence() {
//		return sqlSession.selectOne("room.sequence");
//	}
//	public void insert(RoomDto roomDto) {
//		sqlSession.insert("room.insert", roomDto);
//	}
	public RoomDto insert(RoomDto roomDto) {
		long sequence = sqlSession.selectOne("room.sequence");
		roomDto.setRoomNo(sequence);
		sqlSession.insert("room.insert", roomDto);
		return roomDto;
		//return sqlSession.selectOne("room.detail", sequence);
	}
	
	public List<RoomDto> selectList() {
		return sqlSession.selectList("room.list");
	}
	public List<RoomEnterVO> selectList(String partyAccount) {
		return sqlSession.selectList("room.listByEnter", partyAccount);
	}
	public RoomDto selectOne(long roomNo) {
		RoomDto roomDto = sqlSession.selectOne("room.detail", roomNo);
		if(roomDto == null) throw new TargetNotfoundException();
		return roomDto;
	}
	public void enter(long roomNo, String accountId) {
		Map<String, Object> params = new HashMap<>();
		params.put("partyRoom", roomNo);
		params.put("partyAccount", accountId);
		sqlSession.insert("room.enter", params);
	}
	public boolean leave(long roomNo, String accountId) {
		Map<String, Object> params = new HashMap<>();
		params.put("partyRoom", roomNo);
		params.put("partyAccount", accountId);
		return sqlSession.delete("room.leave", params) > 0;
	}
	
	public boolean check(long roomNo, String accountId) {
		Map<String, Object> params = new HashMap<>();
		params.put("partyRoom", roomNo);
		params.put("partyAccount", accountId);
		int count = sqlSession.selectOne("room.check", params);
		return count > 0;
	}
}