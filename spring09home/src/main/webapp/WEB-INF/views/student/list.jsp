<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<h1>학생 ${isSearch ? "검색" : "목록"}</h1>

<h2><a href = "add">신규 등록</a></h2>
<h2><a href = "list">목록 보기</a></h2>

<form action="list" method="get">
	<select name="column">
		<option value="student_name" ${param.column == "student_name" ? "selected" : ""}>이름</option>
		<option value="student_kor" ${param.column == "student_kor" ? "selected" : ""}>국어점수</option>
		<option value="student_eng" ${param.column == "student_eng" ? "selected" : ""}>영어점수</option>
		<option value="student_mat" ${param.column == "student_mat" ? "selected" : ""}>수학점수</option>
	</select>
	<input type ="search" name="keyword" value = "${param.keyword}" required>
	<Button>찾기</Button>
</form>

<table border="1" width="700">
	<thead>
		<tr>
			<th>번호</th>
			<th>프로필</th>
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
				<td><img src = "/student/image?studentNo=${studentDto.getStudentNo()}" width="32" height = "32"></td>
				<td><a href = "detail?studentNo=${studentDto.getStudentNo()}">${ studentDto.getStudentName() }</a></td>
				<td>${ studentDto.getStudentKor() }</td>
				<td>${ studentDto.getStudentEng() }</td>
				<td>${ studentDto.getStudentMat() }</td>
<%-- 				<td>${ studentDto.getStudentAverage() }</td> --%>
<td><fmt:formatNumber value="${studentDto.getStudentAverage()}" pattern="#,##0"/></td>
<%-- 				<td>${ studentDto.getStudentReg() }</td> --%>
<td><fmt:formatDate value="${studentDto.getStudentReg()}" pattern="y년 M월 d일"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%-- 페이지 네비게이터 출력 --%>
<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>