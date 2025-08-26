<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
 
<h1>회원 ${isSearch ? "검색" : "목록"}</h1>

<h2><a href = "save">신규 회원 등록</a></h2>
<h2><a href = "list">회원 목록 보기</a></h2>

<form action="list" method="get">
	<select name="column">
		<option value="member_id" ${param.column == "member_id" ? "selected" : ""}>아이디</option>
		<option value="member_nickname" ${param.column == "member_nickname" ? "selected" : ""}>닉네임</option>
		<option value="member_email" ${param.column == "member_email" ? "selected" : ""}>이메일</option>
		<option value="member_contact" ${param.column == "member_contact" ? "selected" : ""}>연락처</option>
		<option value="member_level" ${param.column == "member_level" ? "selected" : ""}>등급</option>
	</select>
	<input type ="text" name="keyword" value = "${param.keyword}" required>
	<button>검색</button>
</form>

<c:choose>
	<c:when test="${memberList.size() == 0}">
	<h3>검색어를 입력하세요</h3>
	</c:when>
	<c:otherwise>
		<table border="1" width="900">
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>생일</th>
				<th>연락처</th>
				<th>이메일</th>
				<th>등급</th>
				<th>포인트</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody align = "center">
			<c:forEach var = "memberDto" items = "${ memberList }">
				<tr>
					<td><a href="detail?memberId=${memberDto.memberId}">${ memberDto.memberId }</a></td>
					<td>${ memberDto.memberNickname}</td>
					<td>${ memberDto.memberBirth}</td>
					<td>${ memberDto.memberContact}</td>
					<td>${ memberDto.memberEmail}</td>
					<td>${ memberDto.memberLevel}</td>
					<td><fmt:formatNumber value="${memberDto.memberPoint}" pattern="#,##0"/></td>
					<td><fmt:formatDate value="${memberDto.memberJoin}" pattern = "yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan = "7" align = "center">검색 결과 : ${ memberList.size() }명
				</td>
			</tr>
		</tfoot>
		</table>
</c:otherwise>
</c:choose>
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>