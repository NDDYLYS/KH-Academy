<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>도서 상세정보</h1>

<a href = "list">목록보기</a>

<c:choose>
    <c:when test="${bookDto == null}">
        존재하지 않는 도서 정보입니다.
    </c:when>
    <c:otherwise>
        <table border = "1" width = "900">
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
    </c:otherwise>
</c:choose>

<a href = "edit?bookId=${bookDto.getBookId()}">수정</a>
<a href = "remove?bookId=${bookDto.getBookId()}">삭제</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>