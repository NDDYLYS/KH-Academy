<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

    <h1>포켓몬 정보 수정</h1>
    
    <form action = "edit" method = "post">
    	<input type = "hidden" name = "pokemonNo" value = "${pokemonDto.getPokemonNo()}">
    	
    	<input type = "text" name = "pokemonName" value = "${pokemonDto.getPokemonName()}" required>
    	<input type = "text" name = "pokemonType" value = "${pokemonDto.getPokemonType()}" required>
   
   		<button>수정하기</button>
    </form>
    
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>