<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type = "text/javascript">
    function checkPokemonName()
    {
        var input = document.querySelector("[name=pokemonName]");
        var regex = /^[가-힣]{1,10}$/;
        var valid = regex.test(input.value);

        var feedback = input.nextElementSibling;
        feedback.classList.remove("success", "fail");
        feedback.classList.add(valid ? "success" : "fail");
        if (valid)
        {
            feedback.textContent = "올바른 포켓몬 이름입니다.";
        }
        else 
        {
            feedback.textContent = "잘못된 포켓몬 이름입니다.";
        }
    }

    function checkPokemonType()
    {
        var input = document.querySelector("[name=pokemonType]");
        var regex = /^[가-힣\,\.]{1,10}$/;
        var valid = regex.test(input.value);

        var feedback = input.nextElementSibling;
        feedback.classList.remove("success", "fail");
        feedback.classList.add(valid ? "success" : "fail");
        if (valid)
        {
            feedback.textContent = "올바른 포켓몬 속성입니다.";
        }
        else 
        {
            feedback.textContent = "잘못된 포켓몬 속성입니다.";
        }
    }
</script>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<div class = "container w-250 center">
	<form action="./add" method="post" enctype="multipart/form-data">
        <div class = "cell mb-30 center">
            <h1>포켓몬 등록</h1>
        </div>
        <div class = "cell mt-30">
            <label>포켓몬 이름 *</label>
            <input type ="text" class="field w-100" 
            name ="pokemonName" placeholder="(ex)피카츄" 
            oninput="checkPokemonName();" required>
            <div class = "feedback"></div>
        </div>
        <div class = "cell">
            <label>포켓몬 속성 *</label>
            <input type ="text" class="field w-100" 
            name ="pokemonType" placeholder="(ex)전기"
            oninput="checkPokemonType();" required>
            <div class = "feedback"></div>1
        </div>
        <div class = "cell">
            <label>포켓몬 이미지 *</label>
            <input type = "file"
            name = "attach" accept = ".png,.jpg" class = "field w-100">
        </div>
        <div class = "cell mt-30">
            <button class = "btn btn-positive w-100">등록하기</button>
        </div>
	</form>
</div>
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>