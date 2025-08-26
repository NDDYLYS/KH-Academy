<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<h1>회원 비밀번호 수정</h1>

<form action = "password" method = "post">
	<input type = "hidden" name = "memberId" placeholder = "수정할 아이디"
		value = "${ memberDto.memberId }" required>
	<input type = "text" name = "memberPw" placeholder = "수정할 비밀번호"
		value = "" required>
	<button>회원 비밀번호 수정</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>