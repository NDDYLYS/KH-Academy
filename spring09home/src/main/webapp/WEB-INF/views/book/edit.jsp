<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>도서 정보 수정</h1>
    
    <form action = "edit" method = "post">
    	<input type = "hidden" name = "bookId" 
    	value = "${bookDto.getBookId()}">
    	
    	<input type = "text" name = "bookTitle" value = "${bookDto.getBookTitle()}" required>
    	<input type = "text" name = "bookAuthor" value = "${bookDto.getBookAuthor()}" required>
    	<input type = "text" name = "bookPublisher" value = "${bookDto.getBookPublisher()}" required>
    	<input type = "text" name = "bookPublicationDate" value = "${bookDto.getBookPublicationDate()}" required>
    	<input type = "text" name = "bookPrice" value = "${bookDto.getBookPrice()}" required inputmode = "numeric">
    	<input type = "text" name = "bookPageCount" value = "${bookDto.getBookPageCount()}" required inputmode = "numeric">
    	<input type = "text" name = "bookGenre" value = "${bookDto.getBookGenre()}" required>
   
   		<button>수정하기</button>
    </form>