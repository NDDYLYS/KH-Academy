<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
<link rel="stylesheet" type="text/css" href="/summernote/custom-summernote.css">
<script src="/summernote/custom-summernote.js"></script>

<div class = "container w-800">
    <form action="insert" method="post">
        <div class = "cell mb-30 center">
            <h1>자유 게시판 글쓰기</h1>
        </div>
        <div class = "cell">
            <c:if test = "${ param.boardOrigin != null }">
		        <input type = "hidden" name = "boardOrigin" value = "${ param.boardOrigin }">
	        </c:if>
	        <c:if test = "${ sessionScope.loginLevel == '관리자' }">
		        <input type = "checkbox" name = "boardNotice" value = "Y">공지사항으로 등록<br>
	        </c:if>
        </div>
        <div class = "cell">
            <label>글 제목 *</label>
            <input type= "text" name = "boardTitle"
                class = "field w-100" placeholder="제목" required>
        </div>
        <div class = "cell">
            <label>글 내용 *</label>
            <textarea name = "boardContent" class="summernote-editor" required></textarea>
        </div>
        <div class = "cell mt-50">
            <button class = "btn btn-positive w-100">글쓰기</button>
        </div>
    </form>
</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>