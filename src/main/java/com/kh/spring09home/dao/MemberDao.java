package com.kh.spring09home.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.mapper.MemberMapper;
import com.kh.spring09home.vo.PageVO;

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
				+ "member_id, member_pw, member_nickname, member_email) "
			+ "values (?, ?, ?, ?)";
		Object[] params = {
		memberDto.getMemberId(), memberDto.getMemberPw(),
		memberDto.getMemberNickname(), memberDto.getMemberEmail()
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
	
	public List<MemberDto> selectListByAdmin(String loginId, String column, String keyword)
	{
//		Set<String> allowList = Set.of("member_id");
//		
//		if (allowList.contains(column) == false)
//			return List.of(); // 비어있는 리스트;	
		
		String sql = "select * from member where member_level != '관리자' and instr("+column+", ?) > 0"
				+ " order by "+column+" asc, member_id asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, memberMapper, params);
	}
	
	public List<MemberDto> selectListByAdmin(String loginId)
	{
		String sql = "select * from member WHERE member_level != '관리자' order by member_id asc";
    	return jdbcTemplate.query(sql, memberMapper);
	}
	
	public MemberDto selectOne(String memberId) 
	{
		String sql = "select * from member where member_id = ?";
		Object[] params = {memberId};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
	
	public MemberDto selectOneByMemberNickname(String memberNickname) 
	{
		String sql = "select * from member where member_nickname = ?";
		Object[] params = {memberNickname};
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
	
	public int count(PageVO pageVO) 
	{
		if(pageVO.isList()) 
		{
			return 0;//목록은 데이터가 없다! (회원 검색의 특징)
			//String sql = "select count(*) from member";
			//return jdbcTemplate.queryForObject(sql, int.class);
		}
		else 
		{
			String sql ="select count(*) from member "
					+ "where instr(#1, ?) > 0 and member_level != '관리자'";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {pageVO.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, params);
		}
	}
	
	public List<MemberDto> selectListWithPaging(PageVO pageVO) 
	{
		if(pageVO.isList()) 
		{//목록이라면
			return null;//return List.of();//목록은 현재 보여주지 않고 있다
		}
		else 
		{//검색이라면
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from member "
									+ "where instr(#1, ?) > 0 and member_level != '관리자' "
									+ "order by #1 asc, member_id asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {
					pageVO.getKeyword(), pageVO.getBegin(), pageVO.getEnd()
			};//동적할당
			return jdbcTemplate.query(sql, memberMapper, params);
		}
	}
	
	public void connect(String memberId, int attachmentNo) 
	{
		String sql = "insert into member_profile (member_id, attachment_no) values (?, ?)";
		Object[] params = {
				memberId, 
				attachmentNo
		};//동적할당
		jdbcTemplate.update(sql, params);
	}
	
	public int findAttachment(String memberId) 
	{
		String sql = "select attachment_no from member_profile where member_id = ?";
		Object[] params = {memberId};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
}
