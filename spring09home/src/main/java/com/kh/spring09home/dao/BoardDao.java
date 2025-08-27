package com.kh.spring09home.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09home.dto.BoardDto;
import com.kh.spring09home.mapper.BoardMapper;

@Repository
public class BoardDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BoardMapper boardMapper;
	
	public void add(BoardDto boardDto) 
	{
		String sql = "insert into board (board_title, board_content) "
				+ "values (?, ?)";
		Object[] params = 
			{
				boardDto.getBoardTitle(),
				boardDto.getBoardContent()
			};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean edit(BoardDto boardDto) 
	{
		String sql = "update board set board_title=?, "
				+ "board_content=? where board_no=?";
		Object[] params = 
			{
				boardDto.getBoardTitle(),
				boardDto.getBoardContent(),
				boardDto.getBoardNo()
			};
    	return 0 < jdbcTemplate.update(sql, params);
	}
	
	public boolean delete(int boardNo) 
	{
		String sql = "delete board where board_no=?";
		Object[] params = {	boardNo	};
		return 0 < jdbcTemplate.update(sql, params);
	}
	
	public List<BoardDto> selectList(String column, String keyword)
	{
		Set<String> allowList = Set.of("board_title", "board_writer", 
				"board_content");
		
		if (allowList.contains(column) == false)
			return List.of(); // 비어있는 리스트;	
		
		String sql = "select * from book where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, board_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, boardMapper, params);
	}
	
	public List<BoardDto> selectList()
	{
		String sql = "select * from board order by board_no asc";
    	return jdbcTemplate.query(sql, boardMapper);
	}

	public BoardDto selectOne(int boardNo) 
	{
		String sql = "select * from board where book_id = ?";
		Object[] params = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
}