<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

 <h2>상품권 수정</h2>
 
<form action = "edit" method = "post" enctype = "multipart/form-data">
	<input type = "hidden" name = "giftcardNo" 
		value = "${giftcardDto.giftcardNo}">
	
	<input type = "text" name = "giftcardName" value = "${giftcardDto.giftcardName}" required>
	<input type = "text" name = "giftcardContent" value = "${giftcardDto.giftcardContent}" required>
	<input type = "text" name = "giftcardPrice" value = "${giftcardDto.giftcardPrice}" required>
	<input type = "text" name = "giftcardPoint" value = "${giftcardDto.giftcardPoint}" required>
	<input type = "file" name = "attach" accept = ".png,.jpg,.webp">
	
	<button>수정하기</button>
</form>
 
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>