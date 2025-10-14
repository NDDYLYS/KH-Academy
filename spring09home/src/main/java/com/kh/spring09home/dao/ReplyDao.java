package com.kh.spring09home.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09home.dto.ReplyDto;
import com.kh.spring09home.mapper.ReplyMapper;

@Repository
public class ReplyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ReplyMapper replyMapper;
	
	// 댓글은 전체가 아니라 회원 또는 글 별로 조회
	
	public List<ReplyDto> selectList(String replyWriter)
	{
		String sql = "select * from reply where reply_writer = ? order by reply_no asc";
		Object[] params = {replyWriter};
		return jdbcTemplate.query(sql, replyMapper, params);
	}
	
	public List<ReplyDto> selectList(int replyTarget)
	{
		String sql = "select * from reply where reply_target = ? order by reply_no asc";
		Object[] params = {replyTarget};
		return jdbcTemplate.query(sql, replyMapper, params);
	}
	
	public boolean delete(int replyNo) 
	{
		String sql = "delete reply where reply_no = ?";
		Object[] params = {replyNo};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	public int sequence() 
	{
		String sql= "select reply_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public void insert(ReplyDto replyDto) 
	{
		String sql = "insert into reply(reply_no, reply_writer, reply_target, reply_content) "
				+ "values (?, ?, ?, ?)";
		Object[] params = {replyDto.getReplyNo(), replyDto.getReplyWriter(), replyDto.getReplyTarget(), 
				replyDto.getReplyContent()};
		jdbcTemplate.update(sql, params);
	}
}