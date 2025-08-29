<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<form action = "/board/update" method = "post" align = "center">
	<input type = "hidden" name = "boardNo" value = "${ boardDto.boardNo }"required>
	<br>
		<textarea name = "boardTitle" cols="110" required>${ boardDto.boardTitle }</textarea>
	<br><br>
		<textarea name = "boardContent" rows="5" cols="110" required>${boardDto.boardContent }</textarea>
	<br><br><br>
	<button>글 수정</button>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>