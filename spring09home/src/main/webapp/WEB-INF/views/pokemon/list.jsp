<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class = "container w-850">
    <div class = "cell mb-30 center">
        <h1>포켓몬 목록</h1>
    </div>

	<div class = "cell left">
		<div class = "flex-box style = "justify-content:center">
		    <select name = "column" class = "field">
		        <option value="pokemon_name" ${param.column == "pokemon_name" ? "selected" : ""}>이름</option>
		        <option value="pokemon_type" ${param.column == "pokemon_type" ? "selected" : ""}>속성</option>
		    </select>
		    <input type ="search" name="keyword" value = "${param.keyword}" class = "field" required>
		    <Button class = "btn btn-positive">검색</Button>
	    </div>
	</div>
	
	<div class = "cell right">
	    <a href = "add" class = "btn me-10  btn-neutral">신규등록</a>
	</div>

    <div class = "cell">
        <table class = "table table-hover table-sprited w-100 center">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>이미지</th>
                    <th>이름</th>
                    <th>속성</th>
                    <th><i class="fa-solid fa-heart red"></i></th>
                </tr>
            </thead>

            <tbody>
				<c:forEach var="pokemonDto" items="${ pokemonList }">
					<tr>
						<td>${ pokemonDto.getPokemonNo() }</td>
						<td><img src = "/pokemon/image?pokemonNo=${pokemonDto.getPokemonNo()}" width="32" height = "32"></td>
						<td><a href="detail?pokemonNo=${pokemonDto.getPokemonNo()}">${ pokemonDto.getPokemonName() }</a></td>
						<td>${ pokemonDto.getPokemonType() }</td>
						<td><i class="fa-regular fa-heart red"></i>${pokemonDto.pokemonLike }</td>
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
    </div>
</div>

<!-- <table border="1" width="400"> -->

<!-- 	<tbody align="center"> -->
<%-- 		<c:forEach var="pokemonDto" items="${ pokemonList }"> --%>
<!-- 			<tr> -->
<%-- 				<td>${ pokemonDto.getPokemonNo() }</td> --%>
<%-- 				<td><img src = "/pokemon/image?pokemonNo=${pokemonDto.getPokemonNo()}" width="32" height = "32"></td> --%>
<%-- 				<td><a href="detail?pokemonNo=${pokemonDto.getPokemonNo()}">${ pokemonDto.getPokemonName() }</a></td> --%>
<%-- 				<td>${ pokemonDto.getPokemonType() }</td>		 --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</tbody> -->
<!-- 	<tfoot> -->
<!-- 		<tr> -->
<!-- 			<td colspan="7"> -->
<!-- 				검색결과 :  -->
<%-- 				${pageVO.begin} - ${pageVO.end} --%>
<!-- 				/ -->
<%-- 				${pageVO.dataCount}개 --%>
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</tfoot>	 -->
<!-- </table> -->

<%-- 페이지 네비게이터 출력 --%>
<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>