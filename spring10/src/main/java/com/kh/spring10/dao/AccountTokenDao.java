package com.kh.spring10.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.AccountDto;

@Repository
public class AccountTokenDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(AccountDto accountDto) {
		sqlSession.insert("accountToken.insert", accountDto);
	}
}
