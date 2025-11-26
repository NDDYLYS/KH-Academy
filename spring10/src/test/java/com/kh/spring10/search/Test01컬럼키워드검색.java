package com.kh.spring10.search;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01컬럼키워드검색 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		
	}
}
