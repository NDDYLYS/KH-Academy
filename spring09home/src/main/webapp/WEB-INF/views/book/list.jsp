<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>도서 ${isSearch ? "검색" : "목록"}</h1>

<h2><a href = "save">신규 등록</a></h2>
<h2><a href = "list">목록 보기</a></h2>

<h2>도서 수 : ${ bookList.size() }명</h2>

<form action="list" method="get">
	<select name="column">
		<option value="book_title" ${column == "book_title" ? "selected" : ""}>책 제목</option>
		<option value="book_author" ${column == "book_author" ? "selected" : ""}>저자</option>
		<option value="book_publisher" ${column == "book_publisher" ? "selected" : ""}>출판사</option>
	</select>
	<input type ="text" name="keyword" value = "${keyword}" required="required">
	<button>검색</button>
</form>

<table border="1" width="900">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>저자</th>
			<th>출판사</th>
			<th>장르</th>
			<th>출간일</th>
			<th>가격</th>
			<th>페이지 수</th>
		</tr>
	</thead>
	<tbody align = "center">
		<c:forEach var = "bookDto" items = "${ bookList }">
			<tr>
				<td>${ bookDto.getBookId() }</td>
				<td><a href="detail?bookId=${bookDto.getBookId()}">${ bookDto.getBookTitle() }</a></td>
				<td>${ bookDto.getBookAuthor() }</td>
				<td>${ bookDto.getBookPublisher() }</td>
				<td>${ bookDto.getBookGenre() }</td>
				<td>${ bookDto.getBookPublicationDate() }</td>
<td align = "right"><fmt:formatNumber value="${bookDto.getBookPrice()}" pattern="#,##0"/></td>
				<td align = "right">${ bookDto.getBookPageCount() }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>