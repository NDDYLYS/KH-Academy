<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<h1>포켓몬 등록</h1>

<form action = "./add" method = "post" enctype = "multipart/form-data">
<input type = "text" name = "pokemonName" placeholder = "이름을 입력하세요.">
<input type = "text" name = "pokemonType" placeholder = "속성을 입력하세요.">
<input type = "file" name = "attach" accept = ".png,.jpg">
<button>포켓몬 등록</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>