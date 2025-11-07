<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<!-- <div class = "container w-300"> -->
<!--     <div class = "cell"> -->
<!--         <h2>회원 탈퇴</h2> -->
<!--     </div> -->
<!--     <div class = "cell"> -->
<!--         <h5>탈퇴를 위해 비밀번호를 한 번 더 입력해주세요.</h5> -->
<!--     </div> -->
<!--     <div class = "cell"></div> -->
<!--         <label>비밀번호</label><br> -->
<!--         <input type = "password" name = "memberPw" class = "field" required> -->
<!--     <div class = "cell right"> -->
<!--         <button class = "btn btn-negative">탈퇴하기</button> -->
<!--     </div> -->
<!-- </div> -->


<form action = "drop" method = "post">
	<div class = "container w-300">
	    <div class = "cell">
	        <h2>회원 탈퇴</h2>
	    </div>
	    <div class = "cell">
	        <h5>탈퇴를 위해 비밀번호를 한 번 더 입력해주세요.</h5>
	    </div>
	    <div class = "cell"></div>
	        <label>비밀번호</label><br>
	        <input type = "password" name = "memberPw" class = "field" required>
	    <div class = "cell right">
	        <button class = "btn btn-negative">탈퇴하기</button>
	    </div>
	</div>
</form>

<c:if test = "${param.error != null}">
	<h3 style="color:red">비밀번호가 일치하지 않습니다.</h3>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>