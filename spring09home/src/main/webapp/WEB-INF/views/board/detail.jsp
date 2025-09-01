<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<h3>글 번호 : ${boardDto.boardNo }, 작성자 : ${boardDto.boardWriter }</h3>
<h1>글 제목 : ${boardDto.boardTitle }</h1>
<pre>
	<h1>본문 : ${boardDto.boardContent }</h1>
</pre>
<h3>조회수 : ${boardDto.boardRead }, 좋아요 : ${boardDto.boardLike }</h3>
<h5>작성일 : <fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm:ss"/>, 수정일 : <fmt:formatDate value="${boardDto.boardEtime}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>

<c:if test = "${ sessionScope.loginId != null }">
	<c:choose>
		<c:when test="${ sessionScope.loginId == boardDto.boardWriter }">
			<a href = "/board/delete?boardNo=${boardDto.boardNo}" style="float: right;"> [삭제] </a>
			<a href = "/board/update?boardNo=${boardDto.boardNo}" style="float: right;"> [수정] </a>
		</c:when>
		<c:when test="${ sessionScope.loginLevel eq '관리자' }">
			<a href = "/board/delete?boardNo=${boardDto.boardNo}" style="float: right;"> [삭제] </a>
		</c:when>
	</c:choose>
</c:if>

<a href = "/board/insert" style="float: right;"> [글 쓰기] </a>
	
<%-- </c:if> --%>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>