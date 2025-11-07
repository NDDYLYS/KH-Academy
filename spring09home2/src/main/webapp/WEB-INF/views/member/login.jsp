<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container">

	<div class="row mt-2">
		<div class="col-md-6 offset-md-3 col-sm-10 offset-sm-1 text-center">
			<label class="fs-1">로그인</label>
		</div>
	</div>

	<form action = "login" method = "post">
		<div class="row mt-2">
			<div class="col-md-6 offset-md-3 col-sm-10 offset-sm-1 text-center">
				<input type="text" name="memberId" placeholder = "아이디를 입력하세요." class = "input-control" required>
			</div>
		</div>
		
		<div class="row mt-2">
			<div class="col-md-6 offset-md-3 col-sm-10 offset-sm-1 text-center">
				<input type="password" name="memberPw" placeholder = "비밀번호를 입력하세요." class = "input-control" required>
			</div>
		</div>
		
		<div class="row mt-4">
			<div class="col-md-6 offset-md-3 col-sm-10 offset-sm-1 text-center">
				<button class="btn btn-primary" type="submit">로그인</button>
			</div>
		</div>
		
		<hr>
		
		<div class="row mt-2">
			<div class="col-4 offset-2 text-end">
				<a href = "findMemberId">아이디 찾기</a>
			</div>
			<div class="col-4 text-start">
				<a href = "findMemberPw">비밀번호 찾기</a>
			</div>
		</div>
		
		<div class="row mt-2">
			<div class="col-12 text-center">
	        	<c:if test = "${ param.error != null }">
	        		<span class="fs-4 text-danger">입력하신 정보가 일치하지 않습니다.</span>
	        	</c:if>
	    	</div>
		</div>
	</form>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>