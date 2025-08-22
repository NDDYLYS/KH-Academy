<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
        </table>
    </c:otherwise>
</c:choose>
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>