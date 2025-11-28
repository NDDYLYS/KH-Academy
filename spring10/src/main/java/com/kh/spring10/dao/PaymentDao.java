package com.kh.spring10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestAttribute;

import com.kh.spring10.dto.PaymentDto;
import com.kh.spring10.vo.TokenVO;

@Repository
public class PaymentDao {
	@Autowired
	private SqlSession sqlSession;
	
	public long sequence() 
	{
		return sqlSession.selectOne("payment.sequence");
	}
	
	public long insert(PaymentDto paymentDto) 
	{
		return sqlSession.insert("payment.insert", paymentDto);
	}
	
	public List<PaymentDto> selectList(TokenVO tokenVO)
	{
		return sqlSession.selectList("payment.listByOwner", tokenVO);
	}
}
