\<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<h3>글 번호 : ${boardDto.boardNo }

<c:choose>
	<c:when test="${ memberDto != null }">
	, 아이디 : ${boardDto.boardWriter },
	<a href = "/member/detail?memberId=${ memberDto.memberId }">닉네임 : ${ memberDto.memberNickname }</a>
	닉네임 : ${ memberDto.memberNickname }
	(${memberDto.memberLevel })
	</c:when>
	
	<c:otherwise>
	| 탈퇴한 사용자입니다
	</c:otherwise>
</c:choose>
</h3>
<h1>
글 제목 : ${boardDto.boardTitle }
<c:if test= "${ boardDto.boardEtime != null }">
(수정됨)
</c:if>

</h1>
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
		<c:when test="${ sessionScope.loginLevel == '관리자' }">
			<a href = "/board/delete?boardNo=${boardDto.boardNo}" style="float: right;"> [삭제] </a>
		</c:when>
	</c:choose>
</c:if>

<a href = "insert?boardOrigin=${boardDto.boardNo}" style="float: right;"> [답글] </a>
<a href = "insert" style="float: right;"> [글쓰기] </a>
<%-- 	<a href="write?boardOrigin=${boardDto.boardNo}">답글쓰기</a>  --%>
<%-- </c:if> --%>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>