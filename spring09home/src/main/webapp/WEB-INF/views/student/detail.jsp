<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>학생 상세정보</h1>
  
<a href = "list">목록보기</a>

<table border = "1" width = "800">
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

<a href = "edit?studentNo=${studentDto.getStudentNo()}">수정</a>
<a href = "remove?studentNo=${studentDto.getStudentNo()}">삭제</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>