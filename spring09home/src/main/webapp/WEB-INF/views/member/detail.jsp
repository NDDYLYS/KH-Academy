<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>${memberDto.memberId}님의 정보</h1>

<table border="1" width="500">
	<tr>
        <th>프로필</th>
        <td><img src = "/member/profile?memberId=${memberDto.getMemberId()}"
         width="200" height = "200"></td>
    </tr>
	<tr>
		<th>닉네임</th>
		<td>${memberDto.memberNickname}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>가입일</th>
		<td>
			<fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월"/>
		</td>
	</tr>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


