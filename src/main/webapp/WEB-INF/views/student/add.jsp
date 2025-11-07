<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<script type = "text/javascript">
		window.addEventListener("load", function()
        {
            var state = 
            {
                studentNameValid : false,
                studentKorValid : false,
                studentEngValid : false,
                studentMatValid : false,
                ok : function()
                {
                    return this.studentNameValid && 
                    this.studentKorValid &&
                    this.studentEngValid && 
                    this.studentMatValid;
                }
            };

            document.querySelector("[name=studentName]").addEventListener("blur", function()
            {
                var regex = /^[가-힣]{2,7}$/;
                var valid = regex.test(this.value);
                this.classList.remove("success", "fail");
                this.classList.add(valid ? "success" : "fail");
                state.studentNameValid = valid;
            });
            document.querySelector("[name=studentKor]").addEventListener("input", function()
            {
            	var regex = /^[0-9]+$/;
            	var valid = regex.test(this.value) && parseInt(this.value) >= 0 && parseInt(this.value) <= 100;
                this.classList.remove("success", "fail");
                this.classList.add(valid ? "success" : "fail");
                state.studentKorValid = valid;
            });
            document.querySelector("[name=studentEng]").addEventListener("input", function()
            {
            	var regex = /^[0-9]+$/;
            	var valid = regex.test(this.value) && parseInt(this.value) >= 0 && parseInt(this.value) <= 100;
                this.classList.remove("success", "fail");
                this.classList.add(valid ? "success" : "fail");
                state.studentEngValid = valid;
            });
            document.querySelector("[name=studentMat]").addEventListener("input", function()
            {
            	var regex = /^[0-9]+$/;
            	var valid = regex.test(this.value) && parseInt(this.value) >= 0 && parseInt(this.value) <= 100;
            	this.classList.remove("success", "fail");
                this.classList.add(valid ? "success" : "fail");
                state.studentMatValid = valid;
            });

            document.querySelector(".check-form").addEventListener("submit", function(e)
            {
                document.querySelector("[name=studentName]").dispatchEvent(new Event("blur"));
                document.querySelector("[name=studentKor]").dispatchEvent(new Event("input"));
                document.querySelector("[name=studentEng]").dispatchEvent(new Event("input"));
                document.querySelector("[name=studentMat]").dispatchEvent(new Event("input"));

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
    
<div class = "container w-400">
    <form action="add" method="post" enctype="multipart/form-data" class = "check-form">
        <div class = "cell mb-30 center">
            <h1>학생 등록</h1>
        </div>
        <div class = "cell mt-30">
            <label>학생 이름 *</label>
            <input type= "text" name = "studentName"
             class = "field w-100" placeholder="(ex)홍길동">
        </div>
        <div class = "cell mt-10">
            <label>국어점수 *</label>
            <input type= "number" name = "studentKor"
             class = "field w-100" placeholder="0~100" 
             inputmode = "numeric">
        </div>
        <div class = "cell mt-10">
            <label>영어점수 *</label>
            <input type= "number" name = "studentEng"
             class = "field w-100" placeholder="0~100" 
             inputmode = "numeric">
        </div>
        <div class = "cell mt-10">
            <label>수학점수 *</label>
            <input type= "number" name = "studentMat"
             class = "field w-100" placeholder="0~100" 
             inputmode = "numeric">
        </div>
        <div class = "cell">
            <label>학생 사진 *</label>
            <input type = "file"
            name = "attach" accept = ".png,.jpg" class = "field w-100">
        </div>
        <div class = "cell">
            <button type = "submit" class = "btn btn-positive w-100">
            	<i class="fa-solid fa-floppy-disk"></i>
            	등록하기
            </button>
        </div>
    </form>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>