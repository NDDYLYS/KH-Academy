<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!Doctype HTML>
<html>
    <head>
        <title>홈페이지</title>
        <link rel="stylesheet" type="text/css" href="/css/commons.css">
        <script src="/js/commons.js"></script>
    </head>
    <body>
        <h1>이벤트 신청 페이지</h1>
        <form action="/event" method="post">
            이름 : <input type="text" name="name"> 
            <button type="submit">신청</button>
        </form>
        <h2><a href="/">홈으로</a></h2>
    </body>
</html>