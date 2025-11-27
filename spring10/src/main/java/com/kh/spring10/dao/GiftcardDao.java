package com.kh.spring10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.GiftcardDto;

@Repository
public class GiftcardDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<GiftcardDto> selectList(){
		return sqlSession.selectList("giftcard.list");
	}
	
	public GiftcardDto selectOne(long giftcardNo) {
		return sqlSession.selectOne("giftcard.list", giftcardNo);
	}
}
