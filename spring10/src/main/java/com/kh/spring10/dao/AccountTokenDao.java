package com.kh.spring10.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.AccountTokenDto;

@Repository
public class AccountTokenDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(AccountTokenDto accountTokenDto ) {
		sqlSession.insert("accountToken.insert", accountTokenDto);
	}
	
	public AccountTokenDto selectOne (AccountTokenDto accountTokenDto) 
	{
		return sqlSession.selectOne("accountToken.detail", accountTokenDto);
	}
	
	public boolean delete(Long accountTokenNo) {
		return sqlSession.delete("accountToken.delete", accountTokenNo) > 0;
	}
	
	public boolean deleteById(AccountTokenDto accountTokenDto) {
		return sqlSession.delete("accountToken.deleteById", accountTokenDto) > 0;
	}
}
