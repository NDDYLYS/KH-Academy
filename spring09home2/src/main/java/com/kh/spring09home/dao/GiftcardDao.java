package com.kh.spring09home.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09home.dto.GiftcardDto;
import com.kh.spring09home.mapper.GiftcardMapper;

@Repository
public class GiftcardDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private GiftcardMapper giftcardMapper;
	
	public void add(GiftcardDto giftcardDto) 
	{
		String sql = "insert into giftcard values (?, ?, ?, ?, ?)";
		Object[] params = {
				giftcardDto.getGiftcardNo(),
				giftcardDto.getGiftcardName(),
				giftcardDto.getGiftcardContent(),
				giftcardDto.getGiftcardPrice(),
				giftcardDto.getGiftcardPoint()};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean edit(GiftcardDto giftcardDto) 
	{
		String sql = "update giftcard set "
				+ "giftcard_name = ?, "
				+ "giftcard_content = ?, "
				+ "giftcard_price = ?, "
				+ "giftcard_point = ? "
				+ "where giftcard_no = ?";
		Object[] params = {giftcardDto.getGiftcardName(),
				giftcardDto.getGiftcardContent(),
				giftcardDto.getGiftcardPrice(),
				giftcardDto.getGiftcardPoint(),
				giftcardDto.getGiftcardNo()};
		int result = jdbcTemplate.update(sql, params);
		return 0 < result;
	}
	
	public boolean delete(int giftcardNo) 
	{
		String sql = "delete giftcard where giftcard_no = ?";
		Object[] params = {giftcardNo};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<GiftcardDto> list()
	{
		String sql = "select * from giftcard order by giftcard_no asc";
    	return jdbcTemplate.query(sql, giftcardMapper);
	}
	
	public GiftcardDto selectOne(int giftcardNo)
	{
		String sql = "select * from giftcard where giftcard_no = ?";
		Object[] params = {giftcardNo};
		List<GiftcardDto> list = jdbcTemplate.query(sql, giftcardMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
	
	public void connect(int giftcardNo, int attachmentNo) 
	{
		String sql = "insert into giftcard_image values (?, ?)";
		Object[] params = {
				giftcardNo, 
				attachmentNo
		};//동적할당
		jdbcTemplate.update(sql, params);
	}
	
	public int findAttachment(int giftcardNo) 
	{
		String sql = "select attachment_no from giftcard_image where giftcard_no = ?";
		Object[] params = {giftcardNo};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	
	public int sequence() 
	{
		String sql = "select giftcard_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
}
