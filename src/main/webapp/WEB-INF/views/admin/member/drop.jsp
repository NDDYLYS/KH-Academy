<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action = "drop" method = "post">
	<div class = "container w-300">
	    <div class = "cell">
	        <h2>회원 강퇴</h2>
	    </div>
	    <div class = "cell">
	       	<h5>정말로 강퇴하시겠습니까?</h5>
	    </div>
	    <div class = "cell right">
	        <button class = "btn btn-negative">강퇴하기</button>
	    </div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>