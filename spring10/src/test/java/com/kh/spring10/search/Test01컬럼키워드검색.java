package com.kh.spring10.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring10.dto.AccountDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01컬럼키워드검색 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		Map<String, Object> params = new HashMap<>();
		params.put("column","account_id");
		params.put("keyword", "test");
		
		List<AccountDto> list = sqlSession.selectList("account.search", params);
		for(int i = 0; i < list.size(); i++) {
			log.info(list.get(i).toString());
		}
	}
}
