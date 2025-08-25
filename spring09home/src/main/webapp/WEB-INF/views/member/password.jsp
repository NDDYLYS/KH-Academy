<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<h1>회원 비밀번호 수정</h1>

<form action = "password" method = "post">
	<input type = "password" name = "oldPassword" placeholder = "옛 비밀번호"
		value = "">
	<input type = "password" name = "newPassword" placeholder = "수정할 비밀번호"
		value = "">
	<button>회원 비밀번호 확인</button>
</form>

<c:if test = "${param.error != null}">
	<h3 style="color:red">비밀번호가 일치하지 않습니다.</h3>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>