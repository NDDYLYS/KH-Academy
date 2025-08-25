<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<h1>회원 비밀번호 수정</h1>

<form action = "passeword" method = "post">
	<input type = "text" name = "memberPw" 
		value = "${memberDto.memberPw}">
	<button>회원 비밀번호 수정</button>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>