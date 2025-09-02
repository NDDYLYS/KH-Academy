package com.kh.spring09home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09home.dto.BoardDto;

@Component
public class BoardListMapper implements RowMapper<BoardDto> {
	@Override
	public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo(rs.getInt("board_no"));
		boardDto.setBoardTitle(rs.getString("board_title"));
		boardDto.setBoardWtime(rs.getTimestamp("board_wtime"));
		boardDto.setBoardEtime(rs.getTimestamp("board_etime"));
		boardDto.setBoardWriter(rs.getString("board_writer"));
		//* 게시판에서는 내용이 엄청나게 길기 때문에 필요 없는 곳에서는 조회하지 않는 것이 좋다
		//- 하지만 이렇게 바꾸면 조회구문을 select * from board로 쓸 수 없다
		//boardDto.setBoardContent(rs.getString("board_content"));
		boardDto.setBoardRead(rs.getInt("board_read"));
		boardDto.setBoardLike(rs.getInt("board_like"));
		boardDto.setBoardReply(rs.getInt("board_reply"));
		boardDto.setBoardNotice(rs.getString("board_notice"));
		return boardDto;
	}
}