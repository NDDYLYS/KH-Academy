package com.kh.spring09home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.kh.spring09home.dto.GiftcardDto;

@Component
public class GiftcardMapper implements RowMapper<GiftcardDto>
{
	@Override
	public GiftcardDto mapRow(ResultSet rs, int rowNun) throws SQLException 
	{
		GiftcardDto giftcardDto = new GiftcardDto();
		
		giftcardDto.setGiftcardNo(rs.getInt("giftcard_no"));
		giftcardDto.setGiftcardName(rs.getString("giftcard_name"));
		giftcardDto.setGiftcardContent(rs.getString("giftcard_content"));
		giftcardDto.setGiftcardPrice(rs.getInt("giftcard_price"));
		giftcardDto.setGiftcardPoint(rs.getInt("giftcard_point"));
		// TODO Auto-generated method stub
		return giftcardDto;
	}
}
