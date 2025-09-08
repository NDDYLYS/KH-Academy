<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
 
<h1>회원 상세정보</h1>

<a href = "list">회원 목록보기</a>

<c:choose>
    <c:when test="${memberDto == null}">
        존재하지 않는 회원 정보입니다.
    </c:when>
    <c:otherwise>
        <table border = "1" width = "900">
        	<tr>
        		<th>아이디</th>
        		<td>${memberDto.getMemberId()}</td>
        	</tr>
        	 <tr>
        		<th>프로필</th>
        		<td><img src = "/member/profile?memberId=${memberDto.getMemberId()}"
        		 width="200" height = "200"></td>
        	</tr>
        	<tr>
        		<th>닉네임</th>
        		<td>${memberDto.getMemberNickname()}</td>
        	</tr>
        	<tr>
        		<th>생일</th>
        		<td>${memberDto.getMemberBirth()}</td>
        	</tr>
        	<tr>
        		<th>등급</th>
        		<td>${memberDto.getMemberLevel()}</td>
        	</tr>
        	<tr>
        		<th>포인트</th>
        		<td>${memberDto.getMemberPoint()}</td>
        	</tr>
        	<tr>
        		<th>우편번호</th>
        		<td size = "6">${memberDto.getMemberPost()}</td>
        	</tr>
        	<tr>
        		<th>기본주소</th>
        		<td size = "60">${memberDto.getMemberAddress1()}</td>
        	</tr>
        	<tr>
        		<th>상세주소</th>
        		<td size = "60">${memberDto.getMemberAddress2()}</td>
        	</tr>
        	<tr>
        		<th>가입일</th>
        		<td>
        		<fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월 d일 H시 m분 s초"/>
        		</td>
        	</tr>
        	<tr>
        		<th>최종로그인</th>
        		<td>
        		<fmt:formatDate value="${memberDto.memberLogin}" pattern="y년 M월 d일 H시 m분 s초"/>
        		</td>
        	</tr>
        	<tr>
        		<th>비밀번호 변경일</th>
        		<td>
        		<fmt:formatDate value="${memberDto.memberChange}" pattern="y년 M월 d일 H시 m분 s초"/>
        		</td>
        	</tr>
        </table>
    </c:otherwise>
</c:choose>

<h2><a href = "edit">정보 수정</a></h2>
<h2><a href = "password">비밀번호 수정</a></h2>
<h2><a href = "drop">탈퇴</a></h2>
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>