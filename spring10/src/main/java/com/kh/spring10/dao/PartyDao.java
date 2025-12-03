package com.kh.spring10.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PartyDao {
	@Autowired
	private SqlSession sqlSession;
}
