package com.kh.spring10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.AccountDto;
import com.kh.spring10.vo.AccountComplexSearchVO;

@Repository
public class AccountDao {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void insert(AccountDto accountDto) {
		String origin = accountDto.getAccountPw();
		String encoded = passwordEncoder.encode(origin);
		accountDto.setAccountPw(encoded);
		sqlSession.insert("account.insert", accountDto);
	}
	
	public AccountDto selectOne(String accountId) {
		return sqlSession.selectOne("account.detail-id", accountId);
	}
	
	public AccountDto selectOneByAccountNickname(String accountNickname) {
		return sqlSession.selectOne("account.detail-nickname", accountNickname);
	}
	
	public List<AccountDto> selectList(AccountComplexSearchVO vo){
		return sqlSession.selectList("account.complexSearch", params);
	}
}
