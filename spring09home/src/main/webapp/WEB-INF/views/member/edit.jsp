<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원 정보 수정</h1>

<form action = "edit" method = "post">
<!-- 	<input type = "text" name = "memberId"  -->
<%-- 	value = "${memberDto.getMemberId()}" required readonly> --%>
	
	<input type = "text" name = "memberNickname" 
	value = "${memberDto.memberNickname}" required placeholder = "닉네임">
	<input type = "date" name = "memberBirth" 
	value = "${memberDto.memberBirth}" required>
	<input type = "text" name = "memberContact"
	value = "${memberDto.memberContact}" required placeholder = "연락처">
	<input type = "text" name = "memberEmail" 
	value = "${memberDto.memberEmail}" required placeholder = "이메일" inputmode = "email">
	<!-- <input type = "text" name = "memberLevel" -->
	<%-- value = "${memberDto.memberLevel}" required placeholder = "등급"> --%>
	<!-- <input type = "text" name = "memberPoint"  -->
	<%-- value = "${memberDto.memberPoint}" required placeholder = "포인트"> --%>
	<input type = "text" name = "memberPost" 
	value = "${memberDto.memberPost}" placeholder = "우편번호" inputmode = "numeric">
	<input type = "text" name = "memberAddress1" 
	value = "${memberDto.memberAddress1}" placeholder = "기본주소">
	<input type = "text" name = "memberAddress2" 
	value = "${memberDto.memberAddress2}" placeholder = "상세주소">
	<input type = "password" name = "memberPw" 
	value = "" required  placeholder = "확인용 비밀번호">
<button>회원 정보 수정</button>
</form>
    
<c:if test = "${param.error != null}">
	<h3 style="color:red">비밀번호가 일치하지 않습니다.</h3>
</c:if>
    
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>