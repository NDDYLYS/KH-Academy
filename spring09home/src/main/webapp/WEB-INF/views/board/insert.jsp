<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<!-- <form action = "/board/insert" method = "post"> -->
<!-- <input type = "text" name = "boardTitle" placeholder = "제목"> -->
<!-- <input type = "text" name = "boardContent" placeholder = "내용"> -->
<!-- <button>글 등록</button> -->
<!-- </form> -->

<form action = "/board/insert" method = "post" align = "center">
	<c:if test = "${ sessionScope.loginLevel == '관리자' }">
		<input type = "checkbox" name = "boardNotice" value = "Y">공지사항으로 등록<br>
	</c:if>
	<br>
	<textarea name = "boardTitle" cols="110" required></textarea>
	<br><br>
	<textarea name = "boardContent" rows="5" cols="110" required></textarea>
	<br><br><br>
	<button>글 등록</button>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>