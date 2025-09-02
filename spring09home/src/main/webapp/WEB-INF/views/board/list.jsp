<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1 align="center">자유 게시판</h1>

<c:choose>
	<c:when test = "${ sessionScope.loginId != null }">
		<a href = "/board/insert" style="float: right;">글쓰기</a>
	</c:when>
	<c:otherwise>
		<a href = "/member/login" style="float: right;">로그인</a>을 해야 글을 작성할 수 있습니다
<!-- 		../member/login -->
	</c:otherwise>
</c:choose>

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
				<td>${ boardDto.boardWriter == null ? '탈퇴한 사용자' : boardDto.boardWriter }</td>
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

<c:choose>
	<c:when test = "${ sessionScope.loginId != null }">
		<a href = "/board/insert" style="float: right;">글쓰기</a>
	</c:when>
	<c:otherwise>
		<a href = "/member/login" style="float: right;">로그인</a>을 해야 글을 작성할 수 있습니다
<!-- 		../member/login -->
	</c:otherwise>
</c:choose>

<%-- 페이지 네비게이터 --%>
<h2>
<a href = "#">이전</a>
<c:forEach var = "i" begin = "${ start }" end = "${ finish }" step = "1">
	<c:choose>
		<c:when test="${ page == i }">
			<a>${ i }</a>
		</c:when>
		<c:otherwise>
			<a href = "list?page=${ i }&size=${ size }${ searchParams }">${ i }</a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<a href = "#">다음</a>
</h2>

<form action="list">
	<select name="column">
		<option value="board_title" ${column == 'board_title' ? 'selected' : ''}>제목</option>
		<option value="board_writer" ${column == 'board_writer' ? 'selected' : ''}>작성자</option>
	</select>
	<input type="text" name="keyword" value="${keyword}" required>
	<button>검색</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>