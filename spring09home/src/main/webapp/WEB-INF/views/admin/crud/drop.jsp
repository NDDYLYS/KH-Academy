<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원 강퇴</h1>
<h5>정말로 강퇴하시겠습니까?</h5>

<form action = "drop" method = "post">
	<input type = "hidden" name = "memberId" value = "${ param.memberId }">
	<button>강퇴하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>