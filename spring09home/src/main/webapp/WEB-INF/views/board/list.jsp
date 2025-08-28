<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1 align="center">자유 게시판</h1>

<a href = "/board/insert" style="float: right;">글쓰기</a>

<table border="1" width="1900">
	<thead>
		<tr>
			<th width = "50">번호</th>
			<th width = "1300">제목</th>
			<th width = "200">저자</th>
			<th width = "150">작성일자</th>
			<th width = "75">조회수</th>
			<th width = "75">좋아요</th>
		</tr>
	</thead>
	<tbody align = "center">
		<c:forEach var = "boardDto" items = "${ boardList }">
			<tr>
				<td>${ boardDto.boardNo }</td>
				<td><a href="detail?boardNo=${boardDto.boardNo}">${ boardDto.boardTitle }</a></td>
				<td>${ boardDto.boardWriter }</td>
				<c:choose>
					<c:when test="${ boardDto.nextDay() }">
						<td><fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd"/></td>
					</c:when>				
					<c:otherwise>
						<td><fmt:formatDate value="${boardDto.boardWtime}" pattern="HH:mm"/></td>
					</c:otherwise>
				</c:choose>
				<td>${ boardDto.boardRead }</td>
				<td>${ boardDto.boardLike }</td>
			</tr>
		</c:forEach>
		
<!-- 		<tfooter align = "center"> -->
<!-- 			<tr> -->
<%-- 				<c:forEach var = "i" begin="1" end="${ boardCount / 10 }"> --%>
<!-- 					<td> -->
<%-- 						<a href="#">${ i } --%>
<!-- 					</td> -->
<%-- 				</c:forEach> --%>
<!-- 			</tr> -->
<!-- 		</tfooter> -->
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>