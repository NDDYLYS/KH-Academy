<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

    <h1>포켓몬 상세정보</h1>
    
     <a href = "list">목록 보기</a>
    
    <table border = "1" width = "400">
    	<tr width = "15%" align = "center">
    		<th>번호</th>
    		<td>${pokemonDto.getPokemonNo()}</td>
    	</tr>
    	<tr width = "55%" align = "center">
    		<th>이미지</th>
    		<td><img src = "/pokemon/image?pokemonNo=${pokemonDto.getPokemonNo()}" width="220" height = "220"></td>
    	</tr>
    	<tr width = "15%" align = "center">
    		<th>이름</th>
    		<td>${pokemonDto.getPokemonName()}</td>
    	</tr>
    	<tr width = "15%" align = "center">
    		<th>속성</th>
    		<td>${pokemonDto.getPokemonType()}</td>
    	</tr>
    </table>
    
<a href = "edit?pokemonNo=${pokemonDto.getPokemonNo()}">수정</a>
<a href = "remove?pokemonNo=${pokemonDto.getPokemonNo()}">삭제</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>