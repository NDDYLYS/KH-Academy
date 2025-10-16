<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
<link rel="stylesheet" type="text/css" href="/summernote/custom-summernote.css">
<script src="/summernote/custom-summernote.js"></script>

<form action = "update" method = "post" align = "center">
	<c:if test = "${ sessionScope.loginLevel == '관리자' }">
		<input type = "checkbox" name = "boardNotice" value = "Y" ${ boardDto.boardNotice == 'Y' ?
		'checked' : '' }>공지사항으로 등록<br>
	</c:if>
	
	<input type = "hidden" name = "boardNo" value = "${ boardDto.boardNo }"required>
	
	<div class = "cell">
            <label>글 제목 *</label>
            <input type= "text" name = "boardTitle"
                class = "field w-100" placeholder="제목" required value=${boardDto.boardTitle}>
        </div>
        <div class = "cell">
            <label>글 내용 *</label>
            <textarea name = "boardContent" class="summernote-editor" required>${boardDto.boardContent}</textarea>
        </div>
        <div class = "cell mt-50">
            <button class = "btn btn-positive w-100">글수정</button>
        </div>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>