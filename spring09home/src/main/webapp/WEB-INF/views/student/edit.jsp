<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>학생 정보 수정</h1>
    
    <form action = "edit" method = "post">
    	<input type = "hidden" name = "studentNo" 
    	value = "${studentDto.getStudentNo()}">
    	
    	<input type = "text" name = "studentName" 
    	value = "${studentDto.getStudentName()}" required>
    	<input type = "text" name = "studentKor" 
    	value = "${studentDto.getStudentKor()}" required>
    	<input type = "text" name = "studentEng" 
    	value = "${studentDto.getStudentEng()}" required>
    	<input type = "text" name = "studentMat" 
    	value = "${studentDto.getStudentMat()}" required>
    	<input type = "text" name = "studentReg" 
    	value = "${studentDto.getStudentReg()}" required>
   
   		<button>수정하기</button>
    </form>