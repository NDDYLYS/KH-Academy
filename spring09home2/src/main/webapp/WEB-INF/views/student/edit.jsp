<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<div class = "container w-400">
    <form action="add" method="post" enctype="multipart/form-data">
        <div class = "cell mb-30 center">
            <h1>학생 수정</h1>
            <input type = "hidden" name = "studentNo" 
    		value = "${studentDto.getStudentNo()}">
        </div>
        <div class = "cell mt-30">
            <label>학생 이름 *</label>
            <input type= "text" name = "studentName"
             class = "field w-100" placeholder="(ex)홍길동" value = "${studentDto.getStudentName()}">
        </div>
        <div class = "cell mt-10">
            <label>국어점수 *</label>
            <input type= "number" name = "studentKor"
             class = "field w-100" placeholder="0~100" value = "${studentDto.studentKor}" 
             inputmode = "numeric">
        </div>
        <div class = "cell mt-10">
            <label>영어점수 *</label>
            <input type= "number" name = "studentEng"
             class = "field w-100" placeholder="0~100" value = "${studentDto.studentEng}"
             inputmode = "numeric">
        </div>
        <div class = "cell mt-10">
            <label>수학점수 *</label>
            <input type= "number" name = "studentMat"
             class = "field w-100" placeholder="0~100" value = "${studentDto.studentMat}"
             inputmode = "numeric">
        </div>
        <div class = "cell">
            <label>학생 사진 *</label>
            <input type = "file"
            name = "attach" accept = ".png,.jpg" class = "field w-100">
        </div>
        <div class = "cell">
            <button class = "btn btn-positive w-100">수정하기</button>
        </div>
    </form>
</div>

    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>