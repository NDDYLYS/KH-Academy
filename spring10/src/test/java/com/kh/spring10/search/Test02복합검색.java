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
public class Test02복합검색 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		Map<String, Object> params = new HashMap<>();
		//params.put("accountId","testuser");
		//params.put("accountNickname", "테스트유저");
		//params.put("accountEmail", "@gmail.com");
		//params.put("accountContact", "010");
		//params.put("accountBirth", "2005-11-20");
		//params.put("minAccountPoint", 100);
		//params.put("maxAccountPoint", 1000);
		//params.put("beginAccountJoin", "2025-11-20");
//		//params.put("endAccountJoin", "2025-11-23");
//		params.put("accountLevelList", List.of());
//		params.put("accountLevelList", List.of("일반회원"));
//		params.put("accountLevelList", List.of("우수회원"));
		params.put("accountLevelList", List.of("관리자"));
//		params.put("accountLevelList", List.of("일반회원", "우수회원"));
//		params.put("accountLevelList", List.of("우수회원", "관리자"));
//		params.put("accountLevelList", List.of("일반회원", "관리자"));
//		params.put("accountLevelList", List.of("일반회원", "우수회원", "관리자"));
//		params.put("accountPost", 10);
//		params.put("accountAddress1", "");
//		params.put("accountAddress2", "");
		
		
		List<AccountDto> list = sqlSession.selectList("account.complexSearch", params);
		log.debug("결과 수 = {}", list.size());
		for(AccountDto accountDto : list) {
			log.debug(accountDto.toString());
		}
	}
	
}
