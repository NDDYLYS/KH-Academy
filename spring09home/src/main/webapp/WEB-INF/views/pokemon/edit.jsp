<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬 정보 수정</h1>
    
<form action = "edit" method = "post" enctype = "multipart/form-data">
	<input type = "hidden" name = "pokemonNo" value = "${pokemonDto.getPokemonNo()}">
    	
	<input type = "text" name = "pokemonName" value = "${pokemonDto.getPokemonName()}" required>
	<input type = "text" name = "pokemonType" value = "${pokemonDto.getPokemonType()}" required>
   
   <br><br>
   
현재 이미지 : <input type = "file" name = "attach"> <img src = "/pokemon/image?pokemonNo=${pokemonDto.getPokemonNo()}" width="100" height = "100">
   
	<button>수정하기</button>
	
	<input type = "checkbox" name = "remove">기존이미지를 삭제합니다.
</form>
    
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>