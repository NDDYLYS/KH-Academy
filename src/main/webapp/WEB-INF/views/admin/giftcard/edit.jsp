<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

 <h2>상품권 수정</h2>
 
<form action = "edit" method = "post" enctype = "multipart/form-data">
	<input type = "hidden" name = "giftcardNo" 
		value = "${giftcardDto.giftcardNo}">
	
	이름 : <input type = "text" name = "giftcardName" value = "${giftcardDto.giftcardName}" required>
	내용 : <textarea name = "giftcardContent" rows = "4" cols = "60">${giftcardDto.giftcardContent}</textarea>
	가격 : <input type = "text" name = "giftcardPrice" value = "${giftcardDto.giftcardPrice}" required>
	포인트 : <input type = "text" name = "giftcardPoint" value = "${giftcardDto.giftcardPoint}" required>
	<input type = "file" name = "attach" accept = ".png,.jpg,.webp">
	
	<button>수정하기</button>
</form>
 
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>