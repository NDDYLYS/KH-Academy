package com.kh.spring09home.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.error.TargetNotfoundException;
import com.kh.spring09home.mapper.MemberMapper;

@Repository
public class MemberDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberMapper memberMapper;
	
	public void insert(MemberDto memberDto) 
	{
		String sql = "insert into member("
				+ "member_id, member_pw, member_nickname, member_email, "
				+ "member_birth, member_contact,"
				+ "member_post, member_address1, member_address2, "
				+ "member_change"
			+ ") "
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, systimestamp)";
		Object[] params = {
		memberDto.getMemberId(), memberDto.getMemberPw(),
		memberDto.getMemberNickname(), memberDto.getMemberEmail(),
		memberDto.getMemberBirth(), memberDto.getMemberContact(),
		memberDto.getMemberPost(), memberDto.getMemberAddress1(),
		memberDto.getMemberAddress2()
		};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(MemberDto memberDto) 
	{                        
		String sql = "update member set member_id=?, member_pw=?, "
				+ "member_nickname=?, member_birth=?, member_contact=?, "
				+ "member_email=?, member_level=?, member_point=?, "
				+ "member_post=?, member_address1=?, member_address2=?, "
				+ "member_login=?, member_change=systimestamp "
				+ "where member_id=?";
		Object[] params = {memberDto.getMemberId(), memberDto.getMemberPw(), 
				memberDto.getMemberNickname(), memberDto.getMemberBirth(), memberDto.getMemberContact(),
				memberDto.getMemberEmail(), memberDto.getMemberLevel(), memberDto.getMemberPoint(),
				memberDto.getMemberPost(), memberDto.getMemberAddress1(), memberDto.getMemberAddress2(),
				memberDto.getMemberLogin(), memberDto.getMemberId()};
		int result = jdbcTemplate.update(sql, params);
		return 0 < result;
	}
	
	public boolean updateMember(MemberDto memberDto) 
	{
		String sql = "update member set "
				+ "member_nickname=?, member_birth=?, member_contact=?,"
				+ "member_email=?, member_post=?, member_address1=?, "
				+ "member_address2=? where member_id=?";
		Object[] params = {memberDto.getMemberNickname(), memberDto.getMemberBirth(),
				memberDto.getMemberContact(), memberDto.getMemberEmail(),
				memberDto.getMemberPost(), memberDto.getMemberAddress1(),
				memberDto.getMemberAddress2(), memberDto.getMemberId()};
		return 0 < jdbcTemplate.update(sql, params);
	}

	public boolean updatePassword(MemberDto memberDto) 
	{
		String sql = "update member set member_pw=?, member_change=systimestamp "
				+ "where member_id=?";
		Object[] params = {memberDto.getMemberPw(), memberDto.getMemberId()};
		return 0 < jdbcTemplate.update(sql, params);
	}
	
	public boolean delete(String memberId) 
	{
		String sql = "delete member where member_id=?";
    	Object[] params = {memberId};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<MemberDto> selectList(String column, String keyword)
	{
//		Set<String> allowList = Set.of("member_id");
//		
//		if (allowList.contains(column) == false)
//			return List.of(); // 비어있는 리스트;	
		
		String sql = "select * from member where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, member_id asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, memberMapper, params);
	}
	
	public List<MemberDto> selectList()
	{
		String sql = "select * from member order by member_id asc";
    	return jdbcTemplate.query(sql, memberMapper);
	}
	
	public MemberDto selectOne(String memberId) 
	{
		String sql = "select * from member where member_id = ?";
		Object[] params = {memberId};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
	
	public boolean loginUser(String loginId) 
	{
		String sql = "update member set member_login=systimestamp "
				+ "where member_id=?";
		Object[] params = {loginId};
		int result = jdbcTemplate.update(sql, params);
		return 0 < result;	
	}
}
