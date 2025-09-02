package com.kh.spring09home;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring09home.dao.BoardDao;
import com.kh.spring09home.dto.BoardDto;

@SpringBootTest
public class Test02탑N쿼리DAO 
{
	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void test() 
	{
		int page = 1, size = 10;
		
		List<BoardDto> boardList = boardDao.selectListWithPaging(page, size);
		assertEquals(size, boardList.size());
	}
}
