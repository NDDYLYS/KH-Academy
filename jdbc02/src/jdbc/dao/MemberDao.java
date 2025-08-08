package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MemberDto;
import jdbc.insert.JDBCHelper;

public class MemberDao 
{
	public void insert(MemberDto memberDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		//OracleConnector connector = new OracleConnector();
		String sql = "insert into member (member_id, member_pw, "
				+ "member_nickname, member_birth, member_contact, member_email, "
				+ "member_level, member_point, member_post, member_address1,"
				+ "member_address2, member_join, member_login, member_change) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {memberDto.getMemberId(), memberDto.getMemberPw(),
				memberDto.getMemberNickname(), memberDto.getMemberBirth(),
				memberDto.getMemberContact(), memberDto.getMemberEmail(),
				memberDto.getMemberLevel(), memberDto.getMemberPoint(),
				memberDto.getMemberPost(), memberDto.getMemberAddress1(),
				memberDto.getMemberAddress2(), memberDto.getMemberJoin(),
				memberDto.getMemberLogin(), memberDto.getMemberChange()};		
		//connector.RunSQL(sql, params);
		jdbcTemplate.update(sql, params);
	}
}