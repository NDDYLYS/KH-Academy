<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- 좋아요 확인 -->
<script type="text/javascript">
	$(function(){
		var params = new URLSearchParams(location.search);
		var pokemonNo = params.get("pokemonNo");
		
		$.ajax({
			url:"/rest/pokemon/check?pokemonNo=" + pokemonNo,
			method:"get",
			success:function(response){
				if (response.like)
				{
					$("#pokemon-like").removeClass("fa-regular").addClass("fa-solid");
					$("#pokemon-like-count").text(response.count);
				}
				else 
				{
					$("#pokemon-like").removeClass("fa-solid").addClass("fa-regular");	
					$("#pokemon-like-count").text(response.count);
				}
			}
		});
	});
</script>

<!-- 좋아요 -->
<script type="text/javascript">
	$(function(){
		var params = new URLSearchParams(location.search);
		var pokemonNo = params.get("pokemonNo");
		
		$("#pokemon-like").on("click", function(){
			$.ajax({
				url:"/rest/pokemon/action?pokemonNo=" + pokemonNo,
				method:"get",
				success:function(response){
					if (response.like)
					{
						$("#pokemon-like").removeClass("fa-regular").addClass("fa-solid");
						$("#pokemon-like-count").text(response.count);
					}
					else 
					{
						$("#pokemon-like").removeClass("fa-solid").addClass("fa-regular");	
						$("#pokemon-like-count").text(response.count);
					}
				}
			});
		});
	});
</script>

<div class = "container w-500">
    <div class = "cell">
        <h1>포켓몬 상세정보</h1>
    </div>
    <div class = "cell right">
        <a href = "list" class = "btn btn-nuetral">목록 보기</a>
    </div>
    <div class = "cell">
        <table class = "table table-hover table-sprited w-100 center">
            <tr width = "5%" align = "center">
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
            <tr width = "10%" align = "center">
                <th><i class="fa-regular fa-heart"></i></th>
                <td>
                	<div>
						<i id="pokemon-like" class="fa-regular fa-heart red"></i> 
						<span id="pokemon-like-count">?</span>
					</div>
                </td>
            </tr>
        </table>
    </div>
    <div class = "cell right">
        <a href = "edit?pokemonNo=${pokemonDto.getPokemonNo()}" 
        class = "btn btn-nuetral">수정</a>
        <a href = "remove?pokemonNo=${pokemonDto.getPokemonNo()}"
        class = "btn btn-nuetral confirm-link" data-comment="정말로 삭제하시겠습니까?">삭제</a>   
    </div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>