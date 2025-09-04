package com.kh.spring09home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09home.vo.BoardListVO;

@Component
public class BoardListMapper implements RowMapper<BoardListVO> {
	@Override
	public BoardListVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardNo(rs.getInt("board_no"));
		boardListVO.setBoardTitle(rs.getString("board_title"));
		boardListVO.setBoardWriter(rs.getString("board_writer"));
		boardListVO.setBoardWtime(rs.getTimestamp("board_wtime"));
		boardListVO.setBoardEtime(rs.getTimestamp("board_etime"));
		boardListVO.setBoardRead(rs.getLong("board_read"));
		boardListVO.setBoardLike(rs.getLong("board_like"));
		boardListVO.setBoardReply(rs.getInt("board_reply"));
		boardListVO.setBoardNotice(rs.getString("board_notice"));
		
		boardListVO.setBoardGroup(rs.getInt("board_group"));
		boardListVO.setBoardOrigin(rs.getObject("board_origin", Integer.class));
		boardListVO.setBoardDepth(rs.getInt("board_depth"));

		boardListVO.setMemberId(rs.getString("member_id"));
		boardListVO.setMemberNickname(rs.getString("member_nickname"));
		boardListVO.setMemberLevel(rs.getString("member_level"));
		return boardListVO;
	}
}