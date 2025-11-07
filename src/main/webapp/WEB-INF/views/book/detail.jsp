<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class = "container w-500">
    <div class = "cell">
        <h1>도서 상세정보</h1>
    </div>
    <div class = "cell right">
        <a href = "list" class = "btn btn-nuetral">목록 보기</a>
    </div>
    <div class = "cell">
        <table class = "table table-hover table-sprited w-100 center">
          	<tr align = "center">
        		<th>번호</th>
        		<td>${bookDto.getBookId()}</td>
        	</tr>
        	<tr align = "center">
        		<th>표지</th>
        		<td><img src = "/book/image?bookId=${bookDto.getBookId()}" width="264" height = "264"></td>
        	</tr>
        	<tr align = "center">
        		<th>이름</th>
        		<td>${bookDto.getBookTitle()}</td>
        	</tr>
        	<tr align = "center">
        		<th>저자</th>
        		<td>${bookDto.getBookAuthor()}</td>
        	</tr>
        	<tr align = "center">
        		<th>출판사</th>
        		<td>${bookDto.getBookPublisher()}</td>
        	</tr>
        	<tr align = "center">
        		<th>출판일</th>
        		<td>${bookDto.getBookPublicationDate()}</td>
        	</tr>
        	<tr align = "center">
        		<th>가격</th>
        		<td><fmt:formatNumber value="${bookDto.getBookPrice()}" pattern="#,##0"/></td>
        	</tr>
        	<tr align = "center">
        		<th>페이지수</th>
        		<td>${bookDto.getBookPageCount()}</td>
        	</tr>
        	<tr align = "center">
        		<th>장르</th>
        		<td>${bookDto.getBookGenre()}</td>
        	</tr>
        </table>
    </div>
    <div class = "cell right">
        <a href = "edit?bookId=${bookDto.getBookId()}" 
        class = "btn btn-nuetral">수정</a>
        <a href = "remove?bookId=${bookDto.getBookId()}"
        class = "btn btn-nuetral">삭제</a>   
    </div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>