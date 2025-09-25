<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type = "text/javascript">
window.addEventListener("load", function()
		{
	            var state = 
				{
	               	pokemonNameValid : false,
	               	pokemonTypeValid : false,
	
	               	ok : function()
					{
	                   		return this.pokemonNameValid && this.pokemonTypeValid;
	              	}
	           };
	
	           document.querySelector("[name=pokemonName]").addEventListener("blur", function()
	{
	               var regex = /^[가-힣]{1,10}$/;
	               var valid = regex.test(this.value);
	               this.classList.remove("success", "fail");
	               this.classList.add(valid ? "success" : "fail");
	               state.pokemonNameValid = valid;
	           });
	           document.querySelector("[name=pokemonType]").addEventListener("input", function()
	{
	               var regex = /^[가-힣,]{1,10}$/;
	               var valid = regex.test(this.value);
	               this.classList.remove("success", "fail");
	               this.classList.add(valid ? "success" : "fail");
	               state.pokemonTypeValid = valid;
	           });
	
	           //폼 검사
	           document.querySelector(".check-form").addEventListener("submit", function(e)
	{
	               document.querySelector("[name=pokemonName]").dispatchEvent(new Event("blur"));
	               document.querySelector("[name=pokemonType]").dispatchEvent(new Event("input"));
	               //var inputs = document.querySelectorAll("[name]");
	
	               if(state.ok() == false)
	               {
	               	window.alert("값이 누락되어 등록할 수 없습니다.");	
	                   e.preventDefault();
	               }
	               else
	               {
	               	var choice = window.confirm("학생을 등록하시겠습니까?");
	               	
	               	if (choice == false)
	               		e.preventDefault();
	               }
	           });
	       });
</script>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<div class = "container w-250 center">
	<form action="./add" method="post" enctype="multipart/form-data" class = "check-insert">
        <div class = "cell mb-30 center">
            <h1>포켓몬 등록</h1>
        </div>
        <div class = "cell mt-30">
            <label>포켓몬 이름 *</label>
            <input type ="text" class="field w-100" 
            name ="pokemonName" placeholder="(ex)피카츄">
            <div class = "feedback"></div>
        </div>
        <div class = "cell">
            <label>포켓몬 속성 *</label>
            <input type ="text" class="field w-100" 
            name ="pokemonType" placeholder="(ex)전기">
            <div class = "feedback"></div>
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