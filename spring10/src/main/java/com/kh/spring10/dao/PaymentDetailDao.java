package com.kh.spring10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.PaymentDetailDto;

@Repository
public class PaymentDetailDao {
	@Autowired
	private SqlSession sqlSession;
	
	public long sequence() 
	{
		return sqlSession.selectOne("paymentDetail.sequence");
	}
	
	public long insert(PaymentDetailDto paymentDetailDto) 
	{
		return sqlSession.insert("paymentDetail.insert", paymentDetailDto);
	}
	
	public List<PaymentDetailDto> selectList(long paymentDetailOrigin){
		return sqlSession.selectList("listByOrigin", paymentDetailOrigin);
	}
}
