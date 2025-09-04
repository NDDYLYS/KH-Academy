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
			<th width = "200">아이디</th>
			<th width = "150">작성일자</th>
			<th width = "75">조회수</th>
			<th width = "75">좋아요</th>
<!-- 			<th width = "50">그룹</th> -->
<!-- 			<th width = "50">상위글</th> -->
<!-- 			<th width = "50">차수</th> -->
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="boardListVO" items="${boardList}" varStatus="status">
		<tr bgcolor="${status.index < noticeCount ? '#ffeaa7' : ''}">
			<td>${boardListVO.boardNo} (${status.index})</td>
			<td align="left">
				<%--차수만큼 띄어쓰기(공지로 표시되는 경우가 아니라면) --%>
				<c:if test="${status.index >= noticeCount}">
					<c:forEach var="i" begin="1" end="${boardListVO.boardDepth}" step="1">
					&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>
					<c:if test="${boardListVO.boardDepth > 0}">
						<img src="/images/test/arrow.png" width="16" height="16">
					</c:if>
				</c:if>
			
				<%-- 공지사항인 경우는 제목앞에 (공지) 추가 --%>
				<c:if test="${boardListVO.boardNotice == 'Y'}">
				(공지)
				</c:if>
				
				<a href="detail?boardNo=${boardListVO.boardNo}">
					${boardListVO.boardTitle}
					<c:if test= "${ boardListVO.boardEtime != null }">
					(수정됨)
					</c:if>
				</a>
			</td>
			<td>
				<a href = "/member/detail?memberId=${ boardListVO.memberId }">
				${boardListVO.boardWriter == null ? 
				'(탈퇴한사용자)' : boardListVO.memberNickname}
				</a>
			</td>
			<td>${boardListVO.boardWtime}</td>
			<td>${boardListVO.boardRead}</td>
			<td>${boardListVO.boardLike}</td>
<%-- 			<td>${boardDto.boardGroup}</td> --%>
<%-- 			<td>${boardDto.boardOrigin}</td> --%>
<%-- 			<td>${boardDto.boardDepth}</td> --%>
		</tr>
		</c:forEach>
	</tbody>
</table>

<!-- 검색창 -->
<form action="list">
	<select name="column">
		<option value="board_title" ${pageVO.column == 'board_title' ? 'selected' : ''}>제목</option>
		<option value="board_writer" ${pageVO.column == 'board_writer' ? 'selected' : ''}>작성자</option>
	</select>
	<input type="text" name="keyword" value="${pageVO.keyword}" required>
	<button>검색</button>
</form>

<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>

<c:choose>
	<c:when test = "${ sessionScope.loginId != null }">
		<a href = "/board/insert" style="float: right;">글쓰기</a>
	</c:when>
	<c:otherwise>
		<a href = "/member/login" style="float: right;">로그인</a>을 해야 글을 작성할 수 있습니다
<!-- 		../member/login -->
	</c:otherwise>
</c:choose>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>