<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class = "container w-600">
    <div class = "cell mb-30 center">
        <h2>로그인</h2>
    </div>
    <form action = "login" method = "post">
        <div class = "cell center">
            <input type = "text" name = "memberId" placeholder = "아이디를 입력하세요." 
            class = "field" required>
        </div>
        <div class = "cell center">
            <input type = "password" name = "memberPw" placeholder = "비밀번호를 입력하세요."
            class = "field" required>
        </div>
        <div class = "cell center">
            <button type = "submit" class ="btn btn-positive mt-20">로그인</button>
        </div>
    </form>

    <div class = "cell center">
        <c:if test = "${ param.error != null }">
         <h2 style = "color:red">입력하신 정보가 일치하지 않습니다.</h2>
        </c:if>
    </div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>