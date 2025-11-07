<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action = "changeMemberPw" method = "post" autocomplete = "off">
	<div class = "container w-400 mt-50">
		<div class = "cell center">
			<h3>비밀번호가 내 기억 속에서 bye bye</h3>
		</div>
		<div class = "cell left">
<!-- 			<label>아이디</label> -->
			<input type = "hidden" name = "memberId" value = "${memberId}">
			<input type="hidden" name="certNumber" value="${certNumber}">
		</div>
		<div class = "cell left">
			<label>비밀번호</label>
			<input type = "password" name = "memberPw" class = "field w-75">
		</div>
		<div class = "cell right">
			<button type = "submit" class = "btn btn-positive">변경하기</button>
		</div>
		<div class = "cell center">
		    <c:if test = "${ param.error != null }">
        		<h2 style = "color:red">입력하신 정보가 없습니다.</h2>
        	</c:if>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>