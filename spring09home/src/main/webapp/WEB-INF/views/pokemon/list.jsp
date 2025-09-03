<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬 목록</h1>

<h2>
	<a href="add">신규 등록</a>
</h2>

<!-- 검색창 구현 -->
<form action="list" method="get">
	<select name="column">
		<option value="pokemon_name" ${param.column == "pokemon_name" ? "selected" : ""}>이름</option>
		<option value="pokemon_type" ${param.column == "pokemon_type" ? "selected" : ""}>속성</option>
	</select> 
	<input type="search" name="keyword" value="${param.keyword}" required>
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
	<tfoot>
		<tr>
			<td colspan="7">
				검색결과 : 
				${pageVO.begin} - ${pageVO.end}
				/
				${pageVO.dataCount}개
			</td>
		</tr>
	</tfoot>	
</table>

<%-- 페이지 네비게이터 출력 --%>
<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>