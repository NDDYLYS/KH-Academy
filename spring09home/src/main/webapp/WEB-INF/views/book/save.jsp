<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<h1>서적 등록</h1>

<form action = "./save" method = "post">
<input type = "text" name = "bookTitle" placeholder = "책 이름을 입력하세요.">
<input type = "text" name = "bookAuthor" placeholder = "책 저자를 입력하세요.">
<input type = "text" name = "bookPublisher" placeholder = "책 출판사를 입력하세요.">
<input type = "date" name = "bookPublicationDate" placeholder = "책 입력하세요.">
<input type = "number" name = "bookPrice" placeholder = "책 가격을 입력하세요." inputmode = "numeric">
<input type = "number" name = "bookPageCount" placeholder = "책 페이지 수를 입력하세요." inputmode = "numeric">
<input type = "text" name = "bookGenre" placeholder = "책 장르를 입력하세요.">
<button>서적 등록</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>