<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<div class = "container w-400">
    <form action="save" method="post" enctype="multipart/form-data">
        <div class = "cell mb-30 center">
            <h1>도서 수정</h1>
            <input type = "hidden" name = "bookId" value = "${bookDto.getBookId()}">
        </div>
        <div class = "cell mt-30">
            <label>도서 제목</label>
            <input type= "text" name = "bookTitle" value = "${bookDto.bookTitle}"
             class = "field w-100" placeholder="(ex)어린왕자" required>
        </div>
        <div class = "cell mt-10">
            <label>도서 저자</label>
            <input type= "text" name = "bookAuthor" value = "${bookDto.bookAuthor}"
             class = "field w-100" placeholder="(ex)홍길동">
        </div>
        <div class = "cell mt-10">
            <label>도서 출판사</label>
            <input type= "text" name = "bookPublisher" value = "${bookDto.bookPublisher}"
             class = "field w-100" placeholder="(ex)출판사">
        </div>
        <div class = "cell mt-10">
            <label>출간일</label>
            <input type= "date" name = "bookPublicationDate" value = "${bookDto.bookPublicationDate}"
             class = "field w-100" placeholder="(ex)출간일">
        </div>
        <div class = "cell mt-10">
            <label>도서 가격</label>
            <input type= "number" name = "bookPrice" value = "${bookDto.bookPrice}"
             class = "field w-100" placeholder="(ex)도서 가격"
             inputmode="numeric">
        </div>
        <div class = "cell mt-10">
            <label>도서 페이지 수</label>
            <input type= "number" name = "bookPageCount" value = "${bookDto.bookPageCount}"
             class = "field w-100" placeholder="(ex)페이지 수"
             inputmode = "numeric">
        </div>
        <div class = "cell mt-10">
            <label>도서 장르</label>
            <input type= "text" name = "bookGenre" value = "${bookDto.bookGenre}"
             class = "field w-100" placeholder="(ex)장르">
        </div>
            <label>도서 표지</label>
            <div class = "cell">
            <input type = "file"
            name = "attach" accept = ".png,.jpg" class = "field w-100">
        </div>
        <div class = "cell">
            <button class = "btn btn-positive w-100">수정하기</button>
        </div>
    </form>
</div>


    <h1>도서 정보 수정</h1>
    
    <form action = "edit" method = "post">
    	<input type = "hidden" name = "bookId" value = "${bookDto.getBookId()}">
    	
    	<input type = "text" name = "bookTitle" value = "${bookDto.getBookTitle()}" required>
    	<input type = "text" name = "bookAuthor" value = "${bookDto.getBookAuthor()}" required>
    	<input type = "text" name = "bookPublisher" value = "${bookDto.getBookPublisher()}" required>
    	<input type = "text" name = "bookPublicationDate" value = "${bookDto.getBookPublicationDate()}" required>
    	<input type = "text" name = "bookPrice" value = "${bookDto.getBookPrice()}" required inputmode = "numeric">
    	<input type = "text" name = "bookPageCount" value = "${bookDto.getBookPageCount()}" required inputmode = "numeric">
    	<input type = "text" name = "bookGenre" value = "${bookDto.getBookGenre()}" required>
   
   		<button>수정하기</button>
    </form>
    
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>