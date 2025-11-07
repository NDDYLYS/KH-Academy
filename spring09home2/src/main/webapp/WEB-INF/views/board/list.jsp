<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
	.board-title-link {
		text-decoration: none;
		color: #2d3436;
		display: inline-block;
		/* transition: transform 0.1s ease-out; */
		transition-property: color, transform;
		transition-duration: 0.1s;
		transition-timing-function: ease-out;
	}
	.board-title-link:hover {
		color: #d63031;
		/* transform: translate(30px, 0); */
		/* transform : rotate(45deg); */
		transform: scale(1.01);
	}
</style>

<div class="container w-850">
	<div class="cell center">
		<h1>자유 게시판</h1>
	</div>
	<div class="cell center">
		타인에 대한 무분별한 비방 또는 욕설은 제제의 대상입니다
	</div>
	<div class="cell right">
		<c:choose>
			<c:when test="${sessionScope.loginId != null}">
				<h3><a href="insert" class="btn btn-neutral">글쓰기</a></h3>
			</c:when>
			<c:otherwise>
				<h3><a href="/member/login">로그인</a>을 해야 글을 작성할 수 있습니다</h3>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="cell">
		<table class="table table-border w-100">
			<thead>
				<tr>
					<th>번호</th>
					<th width="40%">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>좋아요</th>
<!-- 					<th>그룹</th> -->
<!-- 					<th>상위글</th> -->
<!-- 					<th>차수</th> -->
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="boardListVO" items="${boardList}" varStatus="status">
				<tr>
					<td>${boardListVO.boardNo}</td>
					<td>
						<div class="flex-box" style="width:400px; padding-left:${boardListVO.boardDepth * 20  + 10}px">
							<c:if test="${boardListVO.boardDepth > 0}">
								<img src="/images/board/reply.png" width="16" height="16">
							</c:if>
						
							<%-- 공지사항인 경우는 제목앞에 (공지) 추가 --%>
							<c:if test="${boardListVO.boardNotice == 'Y'}">
								<span class="badge">공지</span>
							</c:if>
							
							<a href="detail?boardNo=${boardListVO.boardNo}" class="board-title-link ellipsis">
								${boardListVO.boardTitle}(${boardListVO.boardReply})
							</a>
						</div>
					</td>
					<td>${boardListVO.boardWriter == null ? '(탈퇴한사용자)' : boardListVO.memberNickname}</td>
					<td>${boardListVO.boardWtime}</td>
					<td>${boardListVO.boardRead}</td>
					<td>${boardListVO.boardLike}</td>
<%-- 					<td>${boardListVO.boardGroup}</td> --%>
<%-- 					<td>${boardListVO.boardOrigin}</td> --%>
<%-- 					<td>${boardListVO.boardDepth}</td> --%>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="cell right">
		<c:choose>
			<c:when test="${sessionScope.loginId != null}">
				<h3><a href="insert" class="btn btn-neutral">글쓰기</a></h3>
			</c:when>
			<c:otherwise>
				<h3><a href="/member/login">로그인</a>을 해야 글을 작성할 수 있습니다</h3>
			</c:otherwise>
		</c:choose>
	</div>
	
	<!-- 네비게이터 -->
	<div class="cell">
		<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>
	</div>
	
	<%-- 검색창 --%>
	<div class="cell center mt-30 mb-50">
		<form action="list">
			<div class="flex-box" style="justify-content:center;">
				<select name="column" class="field">
					<option value="board_title" ${pageVO.column == 'board_title' ? 'selected' : ''}>제목</option>
					<option value="board_writer" ${pageVO.column == 'board_writer' ? 'selected' : ''}>작성자ID</option>
					<option value="member_nickname" ${pageVO.column == 'member_nickname' ? 'selected' : ''}>작성자닉네임</option>
				</select>
				<input type="text" name="keyword" value="${pageVO.keyword}" required class="field ms-10">
				<button type="submit" class="btn btn-positive ms-10">검색</button>
			</div>
		</form>
	</div>
	
</div>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>






