package com.kh.spring10.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.PaymentDto;

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
}
