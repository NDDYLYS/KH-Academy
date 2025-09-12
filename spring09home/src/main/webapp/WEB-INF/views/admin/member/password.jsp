<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action = "password" method = "post">
	<div class = "container w-300">
	    <div class = "cell">
	        <h2>회원 비밀번호 수정</h2>
	    </div>
	    <div class = "cell">
	        <input type = "hidden" name = "memberId" placeholder = "수정할 아이디"
			value = "${ memberDto.memberId }" required class = "field">
	    </div>
	    <div class = "cell"></div>
	        <input type = "text" name = "memberPw" placeholder = "수정할 비밀번호"
			value = "" required>
	        <button class = "btn btn-negative">회원 비밀번호 수정</button>
	    </div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>