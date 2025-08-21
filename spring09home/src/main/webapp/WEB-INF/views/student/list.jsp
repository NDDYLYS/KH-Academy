<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>>
    
<h1>학생 ${isSearch ? "검색" : "목록"}</h1>

<h2><a href = "add">신규 등록</a></h2>
<h2><a href = "list">목록 보기</a></h2>

<h2>학생 수 : ${ studentList.size() }명</h2>

<form action="list" method="get">
	<select name="column">
		<option value="student_name">이름</option>
		<option value="student_kor">국어점수</option>
		<option value="student_eng">영어점수</option>
		<option value="student_mat">수학점수</option>
	</select>
	<input type ="search" name="keyword" value = "${keyword}">
</form>

<table border="1" width="700">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>평균</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody align = "center">
		<c:forEach var = "studentDto" items = "${ studentList }">
			<tr>
				<td>${ studentDto.getStudentNo() }</td>
				<td>${ studentDto.getStudentName() }</td>
				<td>${ studentDto.getStudentKor() }</td>
				<td>${ studentDto.getStudentEng() }</td>
				<td>${ studentDto.getStudentMat() }</td>
<%-- 				<td>${ studentDto.getStudentAverage() }</td> --%>
<td><fmt:formatNumber value="${studentDto.getStudentAverage()}" pattern="#,##0.00"/></td>
<%-- 				<td>${ studentDto.getStudentReg() }</td> --%>
<td><fmt:formatDate value="${studentDto.getStudentReg()}" pattern="y년 M월 d일"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>