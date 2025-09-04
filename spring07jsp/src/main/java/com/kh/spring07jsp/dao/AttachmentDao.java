package com.kh.spring07jsp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring07jsp.dto.AttachmentDto;
import com.kh.spring07jsp.mapper.AttachmentMapper;

@Repository
public class AttachmentDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private AttachmentMapper attachmentMapper;
	
	public int sequence() 
	{
		String sql = "select attachment_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public void insert(AttachmentDto attachmentDto) 
	{
		String sql = "insert into attachment (attachment_no, attachment_name, "
				+ "attachment_type, attachment_size) "
				+ "values (?, ?, ?, ?)";
		Object[] params = {attachmentDto.getAttachmentNo(), attachmentDto.getAttachmentName(),
				attachmentDto.getAttachmentType(), attachmentDto.getAttachmentSize()};
		jdbcTemplate.update(sql, params);
	}
}
