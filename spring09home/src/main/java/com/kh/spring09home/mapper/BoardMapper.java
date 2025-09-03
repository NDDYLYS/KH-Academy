package com.kh.spring09home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.kh.spring09home.dto.BoardDto;

@Component
public class BoardMapper implements RowMapper<BoardDto>
{
	@Override
	public BoardDto mapRow(ResultSet rs, int rowNun) throws SQLException 
	{
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo(rs.getInt("board_no"));
		boardDto.setBoardTitle(rs.getString("board_title"));
		boardDto.setBoardWriter(rs.getString("board_writer"));
		boardDto.setBoardWtime(rs.getTimestamp("board_wtime"));
		boardDto.setBoardEtime(rs.getTimestamp("board_etime"));
		boardDto.setBoardContent(rs.getString("board_content"));
		boardDto.setBoardRead(rs.getLong("board_read"));
		boardDto.setBoardLike(rs.getLong("board_like"));
		boardDto.setBoardReply(rs.getInt("board_reply"));
		boardDto.setBoardNotice(rs.getString("board_notice"));
		
		boardDto.setBoardGroup(rs.getInt("board_group"));
		boardDto.setBoardOrigin(rs.getObject("board_origin", Integer.class));
		boardDto.setBoardDepth(rs.getInt("board_depth"));
		
		// TODO Auto-generated method stub
		return boardDto;
	}
}
