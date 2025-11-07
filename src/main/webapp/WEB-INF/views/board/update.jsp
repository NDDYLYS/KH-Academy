<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- summernote -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
<link rel="stylesheet" type="text/css" href="/summernote/custom-summernote.css">
<script src="/summernote/custom-summernote.js"></script>

<%-- textarea에는 value가 없다 --%>
<form action="update" method="post">
<input type="hidden" name="boardNo" value="${boardDto.boardNo}">
	
<div class="container w-800">
	<div class="cell">
		<h1>${boardDto.boardNo} 게시글 수정</h1>
	</div>
	
	<c:if test="${sessionScope.loginLevel == '관리자'}">
	<div class="cell">
		<input type="checkbox" name="boardNotice" value="Y" 
				${boardDto.boardNotice == 'Y' ? 'checked' : ''}> 공지사항으로 등록 <br><br>
	</div>
	</c:if>
	
	<div class="cell">
		<label>제목 <i class="fa-solid fa-asterisk red"></i></label>
		<input type="text" name="boardTitle" value="${boardDto.boardTitle}" class="field w-100">
	</div>
	
	<div class="cell">
		<label>내용 <i class="fa-solid fa-asterisk red"></i></label>
		<textarea name="boardContent" class="summernote-editor">${boardDto.boardContent}</textarea>
	</div>
	
	<div class="cell mt-40">
		<button type="submit" class="btn btn-positive w-100">
			<i class="fa-solid fa-edit"></i>
			<span>수정하기</span>
		</button>
	</div>
</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>