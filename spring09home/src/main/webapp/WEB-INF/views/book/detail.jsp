<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>>

<h1>도서 상세정보</h1>

<a href = "list">목록보기</a>

<c:choose>
    <c:when test="${bookDto == null}">
        존재하지 않는 도서 정보입니다.
    </c:when>
    <c:otherwise>
        <table border = "1" width = "900">
        	<tr>
        		<th>번호</th>
        		<td>${bookDto.getBookId()}</td>
        	</tr>
        	<tr>
        		<th>이름</th>
        		<td>${bookDto.getBookTitle()}</td>
        	</tr>
        	<tr>
        		<th>저자</th>
        		<td>${bookDto.getBookAuthor()}</td>
        	</tr>
        	<tr>
        		<th>출판사</th>
        		<td>${bookDto.getBookPublisher()}</td>
        	</tr>
        	<tr>
        		<th>출판일</th>
        		<td>${bookDto.getBookPublicationDate()}</td>
        	</tr>
        	<tr>
        		<th>가격</th>
        		<td><fmt:formatNumber value="${bookDto.getBookPrice()}" pattern="#,##0"/></td>
        	</tr>
        	<tr>
        		<th>페이지수</th>
        		<td>${bookDto.getBookPageCount()}</td>
        	</tr>
        	<tr>
        		<th>장르</th>
        		<td>${bookDto.getBookGenre()}</td>
        	</tr>
        </table>
    </c:otherwise>
</c:choose>

<a href = "edit?bookId=${bookDto.getBookId()}">수정</a>
삭제