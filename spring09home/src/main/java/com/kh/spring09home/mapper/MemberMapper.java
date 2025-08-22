package com.kh.spring09home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09home.dto.MemberDto;

@Component
public class MemberMapper implements RowMapper<MemberDto>
{
	@Override
	public MemberDto mapRow(ResultSet rs, int rowNun) throws SQLException 
	{
		MemberDto memberDto = new MemberDto();
		
		memberDto.setMemberId(rs.getString("member_id"));
		memberDto.setMemberPw(rs.getString("member_pw"));
		memberDto.setMemberNickname(rs.getString("member_nickname"));
		memberDto.setMemberBirth(rs.getString("member_birth"));
		memberDto.setMemberContact(rs.getString("member_contact"));
		memberDto.setMemberEmail(rs.getString("member_email"));
		memberDto.setMemberLevel(rs.getString("member_level"));
		memberDto.setMemberPoint(rs.getInt("member_point"));
		memberDto.setMemberPost(rs.getString("member_post"));
		memberDto.setMemberAddress1(rs.getString("member_address1"));
		memberDto.setMemberAddress2(rs.getString("member_address2"));
		memberDto.setMemberJoin(rs.getTimestamp("member_join"));
		memberDto.setMemberLogin(rs.getTimestamp("member_login"));
		memberDto.setMemberChange(rs.getTimestamp("member_change"));
		
		// TODO Auto-generated method stub
		return memberDto;
	}
}
