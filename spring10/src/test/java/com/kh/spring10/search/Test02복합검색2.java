package com.kh.spring10.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring10.dto.AccountDto;
import com.kh.spring10.vo.AccountComplexSearchVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02복합검색2 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		AccountComplexSearchVO vo = AccountComplexSearchVO.builder()
					.accountId("test")
					.accountNickname("테스트")
					.accountEmail("@gmail.com")
					.accountContact("111")
					.accountBirth("2003-10-27")
					.minAccountPoint(500)
					.maxAccountPoint(3000)
					.beginAccountJoin("2001-01-01")
					.endAccountJoin("2025-11-26")
					.accountLevelList(List.of("일반회원", "우수회원", "관리자"))
					.accountAddress("서울 강남구 테헤란로")//해결이 필요한 항목
				.build();
		
		List<AccountDto> list = sqlSession.selectList("account.complexSearch", vo);
		log.debug("결과 수 = {}", list.size());
		for(AccountDto accountDto : list) {
			log.debug(accountDto.toString());
		}
	}
}