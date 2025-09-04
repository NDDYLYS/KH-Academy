<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>파일 업로드 테스트</h1>

<form action = "test02" method = "get">
	<input type = "file" name = "uploader">
	<input type = "file" name = "attach">
	<button>업로드</button>
</form>

<form action = "test03" method = "post">
	<input type = "file" name = "uploader">
	<input type = "file" name = "attach">
	<button>업로드</button>
</form>

<form action = "test04" method = "post" enctype="multipart/form-data">
	<input type = "file" name = "uploader">
	<input type = "file" name = "attach">
	<button>업로드</button>
</form>