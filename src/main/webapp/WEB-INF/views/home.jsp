<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

로그인ID
${sessionScope.loginId}
<br>
로그인 등급
${sessionScope.loginLevel} 

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>