<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬 목록</h1>

<h2>
	<a href="add">신규 등록</a>
</h2>

<h2>몬스터 수 : ${ pokemonList.size() }</h2>

<!-- 검색창 구현 -->
<form action="list" method="get">
	<select name="column">
		<option value="pokemon_name">이름</option>
		<option value="pokemon_type">속성</option>
	</select> <input type="search" name="keyword">
</form>

<table border="1" width="400">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>속성</th>
			<th>바로가기</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="pokemonDto" items="${ pokemonList }">
			<tr>
				<td>${ pokemonDto.getPokemonNo() }</td>
				<td>${ pokemonDto.getPokemonName() }</td>
				<td>${ pokemonDto.getPokemonType() }</td>
				<td><a href="detail?pokemonNo=${pokemonDto.getPokemonNo()}">바로가기</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>