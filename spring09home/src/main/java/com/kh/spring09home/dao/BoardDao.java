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
	
	public int insertSequence() 
	{
		String sql = "select board_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);		
	}
	
	public void insert(BoardDto boardDto) 
	{
		String sql = "insert into board (board_no, board_title, "
				+ "board_writer, board_content) "
				+ "values (?, ?, ?, ?)";
		Object[] params = 
			{
				boardDto.getBoardNo(),
				boardDto.getBoardTitle(),
				boardDto.getBoardWriter(),
				boardDto.getBoardContent()
			};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(BoardDto boardDto) 
	{
		String sql = "update board set board_title=?, "
				+ "board_content=?, board_etime=systimestamp where board_no=?";
		Object[] params = 
			{
				boardDto.getBoardTitle(),
				boardDto.getBoardContent(),
				boardDto.getBoardNo()
			};
    	return 0 < jdbcTemplate.update(sql, params);
	}
	
	public boolean delete(long boardNo) 
	{
		String sql = "delete board where board_no=?";
		Object[] params = {	boardNo	};
		return 0 < jdbcTemplate.update(sql, params);
	}
//	
//	public List<BoardDto> selectList(String column, String keyword)
//	{
//		Set<String> allowList = Set.of("board_title", "board_writer", 
//				"board_content");
//		
//		if (allowList.contains(column) == false)
//			return List.of(); // 비어있는 리스트;	
//		
//		String sql = "select * from board where instr("+column+", ?) > 0 "
//				+ "order by board_no desc, "+column+" asc, board_no asc";
//		Object[] params = {keyword};
//		return jdbcTemplate.query(sql, boardMapper, params);
//	}
//	
	public List<BoardDto> selectListWithPaging(String column, String keyword, int page, int size)
	{
		int begin = page * size - (size - 1);
		int end = page * size;
		
		Set<String> allowList = Set.of("board_title", "board_writer", 
				"board_content");
		
		if (allowList.contains(column) == false)
			return List.of(); // 비어있는 리스트;	
		
		String sql = "select * from ("
				+ "select rownum rn TMP.* from ("
				+ "select * from board where instr("+column+", ?) > 0 "
				+ "order by board_no desc, "+column+" asc, board_no asc"
				+ "select * from board"
				+ ")TMP"
				+ ") where rn between? and ?";
		
		//String sql = "select * from board where instr("+column+", ?) > 0 "
		//		+ "order by board_no desc, "+column+" asc, board_no asc";
		Object[] params = {keyword,  begin, end};
		return jdbcTemplate.query(sql, boardMapper, params);
	}
	
	public List<BoardDto> selectListWithPaging(int page, int size)
	{
		int begin = page * size - (size - 1);
		int end = page * size;
		
		String sql = "select * from ("
				+ "select rownum rn TMP.* from ("
				+ "select board_no, board_title, board_writer,"
				+ "select * from board"
				+ ")TMP"
				+ ") where rn between? and ?";
		
		//String sql = "select * from board order by board_no desc, board_no asc";
    	Object[] params = { begin, end};
		return jdbcTemplate.query(sql, boardMapper, params);
	}

	public BoardDto selectOne(int boardNo) 
	{
		String sql = "select * from board where board_no = ?";
		Object[] params = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
	
	public void read(int boardNo) 
	{
		String sql = "update board set board_read=board_read+1"
				+ " where board_no = ?";
		Object[] params = {boardNo};
		jdbcTemplate.update(sql, params);
	}
	
	public void like(int boardNo) 
	{
		String sql = "update board set board_like=board_like+1"
				+ " where board_no = ?";
		Object[] params = {boardNo};
		jdbcTemplate.update(sql, params);
	}
}