<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1 align="center">멘션형 자유 게시판</h1>

<table border="1" width="1900">
	<tbody align="left">
		<c:forEach var="boardListVO" items="${boardList}" varStatus="status">
		<tr bgcolor="${status.index < noticeCount ? '#ffeaa7' : ''}">
			<td>
			No.${ boardListVO.boardNo } 
			(${boardListVO.memberNickname == null ? '탈퇴한 사용자':boardListVO.memberNickname})
			<br><br> 
			<c:if test = "${boardListVO.boardDepth > 0 }">
			@멘션
			</c:if>
			<a href="detail?boardNo=${ boardListVO.boardNo }">${ boardListVO.boardTitle }</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>