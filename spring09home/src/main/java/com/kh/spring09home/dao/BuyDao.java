package com.kh.spring09home.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09home.dto.BuyDto;
import com.kh.spring09home.mapper.BuyMapper;

@Repository
public class BuyDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BuyMapper buyMapper;
	
	public int sequence() 
	{
		String sql = "select buy_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public void insert(BuyDto buyDto) 
	{
		String sql = "insert into buy "
				+ "(buy_no, buy_member_id, buy_giftcard_no, "
				+ "buy_giftcard_name, buy_qty, buy_amount) "
				+ "values (?, ?, ?, ?, ?, ?)";
		Object[] params = {buyDto.getBuyNo(),
				buyDto.getBuyMemberId(),
				buyDto.getBuyGiftcardNo(),
				buyDto.getBuyGiftcardName(),
				buyDto.getBuyQty(),
				buyDto.getBuyAmount()};
		jdbcTemplate.update(sql, params);
	}
	
//	public List<BuyDto> select()
//	{
//		String sql = "select * from buy order by buy_no asc";
//		return jdbcTemplate.query(sql, buyMapper);
//	}
}
