<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- 좋아요 확인 -->
<script type="text/javascript">
	$(function(){
		var params = new URLSearchParams(location.search);
		var boardNo = params.get("boardNo");
		
		$.ajax({
			url:"/rest/board/check?boardNo=" + boardNo,
			method:"get",
			success:function(response){
				if (response.like)
				{
					$("#board-like").removeClass("fa-regular").addClass("fa-solid");
					$("#board-like-count").text(response.count);
				}
				else 
				{
					$("#board-like").removeClass("fa-solid").addClass("fa-regular");	
					$("#board-like-count").text(response.count);
				}
			}
		});
	});
</script>

<!-- 좋아요 -->
<script type="text/javascript">
	$(function(){
		$("#board-like").on("click", function(){
			$.ajax({
				url:"/rest/board/action?boardNo=${boardDto.boardNo}",
				method:"get",
				success:function(response){
					if (response.like)
					{
						$("#board-like").removeClass("fa-regular").addClass("fa-solid");
						$("#board-like-count").text(response.count);
					}
					else 
					{
						$("#board-like").removeClass("fa-solid").addClass("fa-regular");	
						$("#board-like-count").text(response.count);
					}
				}
			});
		});
	});
</script>


<h1>
	${boardDto.boardTitle} 
	<c:if test="${boardDto.boardEtime != null}">
	(수정됨)
	</c:if>
</h1>
<div>
<%-- 	${boardDto.boardWriter == null ? '탈퇴한사용자' : boardDto.boardWriter} --%>

	<c:choose>
		<c:when test="${memberDto == null}">탈퇴한사용자</c:when>
		<c:otherwise>
			<a href="/member/detail?memberId=${memberDto.memberId}">
				${memberDto.memberNickname}
			</a>  
			(${memberDto.memberLevel})
		</c:otherwise>
	</c:choose>
</div>
<div>
	<fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm"/> 
	조회수 ${boardDto.boardRead}
</div>
<hr>
<div style="min-height: 200px">
	<pre>${boardDto.boardContent}</pre>
</div>
<hr>
<div>
	좋아요 <i id="board-like" class="fa-regular fa-heart red"></i> 
	<span id="board-like-count">?</span>  
	댓글 ${boardDto.boardReply}
</div>
<hr>
<div>
	<a href="write">글쓰기</a> 
	<a href="write?boardOrigin=${boardDto.boardNo}">답글쓰기</a> 
	<%-- 내 글일 경우 수정 삭제를 모두 표시 --%>
	<c:if test="${sessionScope.loginId != null}">
	<c:choose>
		<c:when test="${sessionScope.loginId == boardDto.boardWriter}">
			<a href="edit?boardNo=${boardDto.boardNo}">수정</a> 
			<a href="delete?boardNo=${boardDto.boardNo}">삭제</a>
		</c:when>
		<c:when test="${sessionScope.loginLevel == '관리자'}">
			<a href="delete?boardNo=${boardDto.boardNo}">삭제</a>
		</c:when>
	</c:choose>
	</c:if>
	<a href="list">목록</a>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
