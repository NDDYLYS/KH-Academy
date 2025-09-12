<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<div class = "container w-500">
    <div class = "cell">
        <h2>상품권 구매</h2>
    </div>
    <div class = "cell">
        <h5>${ giftcardDto.giftcardName }를 구매합니다(${ giftcardDto.giftcardContent })</h5>
    </div>
    <div class = "cell">
    	<img src = "image?giftcardNo=${giftcardDto.giftcardNo}" width="200" height = "160">
    </div>
    <form action = "buy" method = "post">
	    <div class = "cell">
	        <label>수량</label><br>
	        <input type = "number" name = "buyQty" class = "field w-300" inputmode = "numeric" min = "1" value = "1">
	        <input type="hidden" name="buyGiftcardNo" value="${giftcardDto.giftcardNo}" class = "field">
	    </div>
	    <div class = "cell">
	        <button class = "btn btn-positive w-300">상품권 구매</button>
	    </div>
	</form>
</div>
 
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>