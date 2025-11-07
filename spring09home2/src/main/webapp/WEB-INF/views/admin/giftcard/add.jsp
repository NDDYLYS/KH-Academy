<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class = "container w-400">
    <form action="add" method="post" enctype="multipart/form-data">
        <div class = "cell center">
            <h1>상품권 등록</h1>
        </div>
        <div class = "cell">
            <label>상품권 제목 *</label>
            <input type= "text" name = "giftcardName"
                class = "field w-100" placeholder="(ex)10,000포인트" required>
        </div>
        <div class = "cell">
            <label>상품권 내용 *</label>
            <input type= "text" name = "giftcardContent"
                class = "field w-100" placeholder="(ex)9,900원에 10,000 포인트 증정" required>
        </div>
        <div class = "cell">
            <label>상품권 가격 *</label>
            <input type= "number" name = "giftcardPrice"
                class = "field w-100" placeholder="(ex)9,900" required
                inputmode="numeric">
        </div>
        <div class = "cell">
            <label>상품권 포인트 *</label>
            <input type= "number" name = "giftcardPoint"
                class = "field w-100" placeholder="(ex)10,000" required
                inputmode="numeric">
        </div>
            <label>상품권 표지 *</label>
            <div class = "cell">
            <input type = "file"
            name = "attach" accept = ".png,.jpg,.webp" class = "field w-100">
        </div>
        <div class = "cell mt-30">
            <button class = "btn btn-positive w-100">상품권 등록</button>
        </div>
    </form>
</div>
 
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>