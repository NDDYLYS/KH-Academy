package com.kh.spring09home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09home.dto.BookDto;
import com.kh.spring09home.dto.BuyDto;

@Component
public class BuyMapper implements RowMapper<BuyDto>
{
	@Override
	public BuyDto mapRow(ResultSet rs, int rowNun) throws SQLException 
	{
		BuyDto buyDto = new BuyDto();
		
		buyDto.setBuyNo(rs.getInt("buy_no"));
		buyDto.setBuyMemberId(rs.getString("buy_member_id"));
		buyDto.setBuyGiftcardNo(rs.getInt("buy_giftcard_no"));
		buyDto.setBuyGiftcardName(rs.getString("buy_giftcard_name"));
		buyDto.setBuyTime(rs.getTimestamp("buy_time"));
		buyDto.setBuyQty(rs.getInt("buy_qty"));
		buyDto.setBuyAmount(rs.getInt("buy_amount"));
		
		// TODO Auto-generated method stub
		return buyDto;
	}
}
