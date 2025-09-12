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
	        <label>비밀번호(확인용)</label><br>
	        <input type = "password" name = "oldPassword" class = "field">
	    </div>
	    <div class = "cell"></div>
	        <label>수정할 비밀번호</label><br>
	        <input type = "password" name = "newPassword" class = "field">
	    <div class = "cell right">
	        <button class = "btn btn-negative">비밀번호 수정</button>
	    </div>
	</div>
</form>

<c:if test = "${param.error != null}">
	<h3 style="color:red">비밀번호가 일치하지 않습니다.</h3>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>