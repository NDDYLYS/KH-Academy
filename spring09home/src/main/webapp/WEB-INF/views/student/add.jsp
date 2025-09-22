<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<script type = "text/javascript">
       function checkStudentName()
       {
           var input = document.querySelector("[name=studentName]");
           var regex = /^[가-힣]{2,7}$/;
           var valid = regex.test(input.value);

           input.classList.remove("success", "fail");
           input.classList.add(valid ? "success" : "fail");
       }

       function checkStudentKor()
       {
           var input = document.querySelector("[name=studentKor]");
           var regex = /^(100|[1-9][0-9]|[0-9])$/;
           var valid = regex.test(input.value);

           input.classList.remove("success", "fail");
           input.classList.add(valid ? "success" : "fail");
       }
       function checkStudentEng()
       {
           var input = document.querySelector("[name=studentEng]");
           var regex = /^(100|[1-9][0-9]|[0-9])$/;
           var valid = regex.test(input.value);

           input.classList.remove("success", "fail");
           input.classList.add(valid ? "success" : "fail");
       }
       function checkStudentMat()
       {
           var input = document.querySelector("[name=studentMat]");
           var regex = /^(100|[1-9][0-9]|[0-9])$/;
           var valid = regex.test(input.value);

           input.classList.remove("success", "fail");
           input.classList.add(valid ? "success" : "fail");
       }
   </script>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<div class = "container w-400">
    <form action="add" method="post" enctype="multipart/form-data">
        <div class = "cell mb-30 center">
            <h1>학생 등록</h1>
        </div>
        <div class = "cell mt-30">
            <label>학생 이름 *</label>
            <input type= "text" name = "studentName"
             class = "field w-100" placeholder="(ex)홍길동"
             oninput="checkStudentName();">
            <div class = "success-feedback">훌륭한 학생 이름입니다.</div>
            <div class = "fail-feedback">잘못된 학생 이름입니다.</div>
        </div>
        <div class = "cell mt-10">
            <label>국어점수 *</label>
            <input type= "number" name = "studentKor"
             class = "field w-100" placeholder="0~100" 
             inputmode = "numeric" 
             oninput="checkStudentKor();">
            <div class = "success-feedback">올바른 국어점수입니다.</div>
            <div class = "fail-feedback">옳지 못한 국어점수입니다.</div>
        </div>
        <div class = "cell mt-10">
            <label>영어점수 *</label>
            <input type= "number" name = "studentEng"
             class = "field w-100" placeholder="0~100" 
             inputmode = "numeric" 
             oninput="checkStudentEng();">
            <div class = "success-feedback">올바른 영어점수입니다.</div>
            <div class = "fail-feedback">옳지 못한 영어점수입니다.</div>
        </div>
        <div class = "cell mt-10">
            <label>수학점수 *</label>
            <input type= "number" name = "studentMat"
             class = "field w-100" placeholder="0~100" 
             inputmode = "numeric" 
             oninput="checkStudentMat();">
            <div class = "success-feedback">올바른 수학점수입니다.</div>
            <div class = "fail-feedback">옳지 못한 수학점수입니다.</div>
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