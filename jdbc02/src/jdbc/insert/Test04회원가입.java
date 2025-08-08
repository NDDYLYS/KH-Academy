package jdbc.insert;

import java.sql.Timestamp;
import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test04회원가입 
{
    public static void main(String[] args) 
    {		
    	//Timestamp specificTime = Timestamp.valueOf("2025-08-08 12:34:56");
    	
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberId("abcd12ee2");
		memberDto.setMemberPw("Aa1!abcd");
		memberDto.setMemberNickname("홍123123234길동1");
//		memberDto.setMemberBirth("1995-07-15");
//		memberDto.setMemberContact("01012345678");
		memberDto.setMemberEmail("test_user@testmail");
		memberDto.setMemberLevel("일반회원");
//		memberDto.setMemberPoint(100);
//		memberDto.setMemberPost("12345");
//		memberDto.setMemberAddress1("서울특별시 중구 세종대로 110");
//		memberDto.setMemberAddress2("101호");
		java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
		memberDto.setMemberJoin(now);
//		memberDto.setMemberLogin(null);
//		memberDto.setMemberChange(null);
		
		MemberDao memberDao = new MemberDao();
		memberDao.insert(memberDto);
    }
}