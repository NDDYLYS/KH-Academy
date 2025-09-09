<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>상품권 구매</h2>
 
<h5>${ giftcardDto.giftcardName }를 구매합니다(${ giftcardDto.giftcardContent })</h2>
 
<form action = "buy" method = "post">
<img src = "image?giftcardNo=${giftcardDto.giftcardNo}" width="200" height = "160">

<input type = "hidden" name = "buyMemberId" value = "${ sessionScope.loginId }" required>
<input type = "hidden" name = "buyGiftcardNo" value = "${ giftcardDto.giftcardNo }" required>
<input type = "hidden" name = "buyGiftcardName" value = "${ giftcardDto.giftcardName }" required>

수량 : <input type = "number" name = "buyQty" inputmode = "numeric" 
min = "1" value = "1" required>
<input type = "hidden" name = "buyAmount" value = "${ giftcardDto.giftcardPrice }" required>
<button>상품권 구매</button>
</form>
 
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>