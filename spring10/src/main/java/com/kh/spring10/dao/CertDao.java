package com.kh.spring10.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.CertDto;

@Repository
public class CertDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(CertDto certDto) {
		sqlSession.insert("cert.insert", certDto);
	}
	
	public boolean update(CertDto certDto) {
		return sqlSession.update("cert.update", certDto) > 0;
	}
	
	public boolean delete(String certEmail) {
		return sqlSession.delete("cert.delete", certEmail) > 0;
	}
	
	public CertDto selectOne(String certEmail) {
		return sqlSession.selectOne("cert.detail", certEmail);
	}
}
