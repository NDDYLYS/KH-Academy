<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원 정보 수정</h1>

<form action = "edit" method = "post">
	<input type = "hidden" name = "memberId" 
	value = "${memberDto.getMemberId()}">	
	<input type = "hidden" name = "memberPw" 
	value = "${memberDto.getMemberPw()}" placeholder = "비밀번호">
	<input type = "text" name = "memberNickname" 
	value = "${memberDto.memberNickname}" required placeholder = "닉네임">
	<input type = "date" name = "memberBirth" 
	value = "${memberDto.memberBirth}" required>
	<input type = "text" name = "memberContact"
	value = "${memberDto.memberContact}" required placeholder = "연락처">
	<input type = "text" name = "memberEmail" 
	value = "${memberDto.memberEmail}" placeholder = "이메일" inputmode = "email">
<!-- 	<input type = "text" name = "memberLevel" -->
<%-- 	value = "${memberDto.memberLevel}" placeholder = "등급"> --%>
	<select name = "memberLevel">
		<option ${memberDto.memberLevel == '일반회원' ? 'selected' : ''}>일반회원</option>
		<option ${memberDto.memberLevel == '우수회원' ? 'selected' : ''}>우수회원</option>
	</select>
	<input type = "text" name = "memberPoint" 
	value = "${memberDto.memberPoint}" placeholder = "포인트" inputmode = "numeric">
	<input type = "text" name = "memberPost" 
	value = "${memberDto.memberPost}" placeholder = "우편번호" inputmode = "numeric">
	<input type = "text" name = "memberAddress1" 
	value = "${memberDto.memberAddress1}" placeholder = "기본주소">
	<input type = "text" name = "memberAddress2" 
	value = "${memberDto.memberAddress2}" placeholder = "상세주소">

<button>회원 정보 수정</button>
</form>

    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>