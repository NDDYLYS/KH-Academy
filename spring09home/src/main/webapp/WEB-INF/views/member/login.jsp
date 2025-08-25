<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>로그인</h2>

<form action = "login" method = "post">
<input type = "text" name = "memberId" placeholder = "아이디를 입력하세요." required><br>
<input type = "password" name = "memberPw" placeholder = "비밀번호를 입력하세요." required><br>
<button>로그인</button>
</form>

<!-- error 파라미터가 있다면 오류 메세지 출력 -->
<c:if test = "${ param.error != null }">
	<h2 style = "color:red">입력하신 정보가 일치하지 않습니다.</h2>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>