<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div>
	<h1>KH정보 교육원 스프링 개발자 수업자료</h1>
</div>

<hr>

<div>
<%--  세션ID : ${} --%>
 세션ID : ${pageContext.session.id} - loginId : ${sessionScope.loginId}, loginLevel : ${sessionScope.loginLevel}
</div>

<c:choose>
	<c:when test="${sessionScope.loginId != null && sessionScope.loginLevel == '일반회원'}">
		<a href = "/">Home</a>
		<a href = "/pokemon/list">Pokemon</a>
		<a href = "/student/list">Student</a>
		<a href = "/member/mypage">내 정보</a>
		<a href = "/member/logout">로그아웃</a>
	</c:when>
	<c:when  test="${sessionScope.loginId != null && sessionScope.loginLevel == '우수회원'}">
		<a href = "/">Home</a>
		<a href = "/pokemon/list">Pokemon</a>
		<a href = "/student/list">Student</a>
		<a href = "/book/list">Book</a>
		<a href = "/member/mypage">내 정보</a>
		<a href = "/member/logout">로그아웃</a>
	</c:when>
	<c:when  test="${sessionScope.loginId != null && sessionScope.loginLevel == '관리자'}">
		<a href = "/">Home</a>
		<a href = "/pokemon/list">Pokemon</a>
		<a href = "/student/list">Student</a>
		<a href = "/book/list">Book</a>
		<a href = "/member/logout">로그아웃</a>
		<a href = "/admin/home">[관리메뉴]</a>
	</c:when>
	<c:otherwise>
		<a href = "/">Home</a>
		<a href = "/pokemon/list">Pokemon</a>
		<a href = "/member/join">회원가입</a>
		<a href = "/member/login">로그인</a>
	</c:otherwise>
</c:choose>

<hr>

<div style = "min-height:400px">