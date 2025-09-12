<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class = "container w-500">
    <div class = "cell">
        <h1>학생 상세정보</h1>
    </div>
    <div class = "cell right">
        <a href = "list" class = "btn btn-nuetral">목록 보기</a>
    </div>
    <div class = "cell">
        <table class = "table table-hover table-sprited w-100 center">
            <tr align = "center">
				<th>번호</th>
				<td>${studentDto.getStudentNo()}</td>
			</tr>
			
			<tr align = "center">
				<th>프로필</th>
				<td><img src = "/student/image?studentNo=${studentDto.getStudentNo()}" width="264" height = "264"></td>
			</tr>
			
			<tr align = "center">
				<th>이름</th>
				<td>${studentDto.getStudentName()}</td>
			</tr>
			
			<tr align = "center">
				<th>국어점수</th>
				<td>${studentDto.getStudentKor()}점</td>
			</tr>
			
			<tr align = "center">
				<th>영어점수</th>
				<td>${studentDto.getStudentEng()}점</td>
			</tr>
			
			<tr align = "center">
				<th>수학점수</th>
				<td>${studentDto.getStudentMat()}점</td>
			</tr>
			
			<tr align = "center">
				<th>등록일</th>
				<td>${studentDto.getStudentReg()}</td>
			</tr>
        </table>
    </div>
    <div class = "cell right">
        <a href = "edit?studentNo=${studentDto.getStudentNo()}" 
        class = "btn btn-nuetral">수정</a>
        <a href = "remove?studentNo=${studentDto.getStudentNo()}"
        class = "btn btn-nuetral">삭제</a>   
    </div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>