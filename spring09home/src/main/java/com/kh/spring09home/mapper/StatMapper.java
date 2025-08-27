package com.kh.spring09home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09home.vo.StatVO;

@Component
public class StatMapper implements RowMapper<StatVO>
{
	@Override
	public StatVO mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		StatVO statVO = new StatVO();
		statVO.setTitle(rs.getString("title"));
		statVO.setValue(rs.getDouble("value"));
		return statVO;
	}
}
