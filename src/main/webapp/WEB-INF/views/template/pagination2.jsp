<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<%-- 페이지 네비게이터 (PageVO의 내용을 토대로 작성) --%>
<c:if test = "${ pageVO != null && pageVO.dataCount > 0 }">

<!-- <div class = "container w-800"> -->
<!--     <div class = "cell"> -->
<!--         <div class = "pagination"> -->
<!--             <a href = "#">&lt;</a> -->
<!--             <a href = "#">1</a> -->
<!--             <a href = "#">2</a> -->
<!--             <a href = "#">3</a> -->
<!--             <a href = "#">4</a> -->
<!--             <a href = "#">5</a> -->
<!--             <a href = "#">6</a> -->
<!--             <a href = "#">7</a> -->
<!--             <a href = "#">8</a> -->
<!--             <a href = "#">9</a> -->
<!--             <a href = "#">10</a> -->
<!--             <a href = "#">&gt;</a> -->
<!--         </div> -->
<!--     </div> -->
<!-- </div> -->

<div class = "pagination">
	<c:if test="${ pageVO.firstBlock == false }">
		<a href = "list?page=${ pageVO.prevPage }&${ pageVO.searchParams }">&lt;</a>
	</c:if>
	<c:forEach var = "i" begin = "${ pageVO.blockStart }" end = "${ pageVO.blockFinish }" step = "1">
		<c:choose>
			<c:when test="${ pageVO.page == i }">
				<a class = "on">${ i }</a>
			</c:when>
			<c:otherwise>
				<a href = "list?page=${ i }&${ pageVO.searchParams }">${ i }</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${ pageVO.lastBlock == false }">
		<a href = "list?page=${ pageVO.nextPage }&${ pageVO.searchParams }">&gt;</a>
	</c:if>
</div>

</c:if>