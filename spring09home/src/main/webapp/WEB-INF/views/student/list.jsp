<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class = "container w-600">
    <div class = "cell mb-30 center">
        <h1>학생 목록</h1>
    </div>

    <div class = "cell left">
        <form autocomplete="off">
            <select name = "column" class = "field">
                <option value="student_name" ${param.column == "student_name" ? "selected" : ""}>이름</option>
                <option value="student_kor" ${param.column == "student_kor" ? "selected" : ""}>국어점수</option>
                <option value="student_eng" ${param.column == "student_eng" ? "selected" : ""}>영어점수</option>
                <option value="student_mat" ${param.column == "student_mat" ? "selected" : ""}>수학점수</option>
            </select>
            <input type ="search" name="keyword" value = "${param.keyword}" class = "field" required>
            <Button type = "submit" class = "btn btn-positive">검색</Button>
        </form>
    </div>

    <div class = "cell right">
        <a href = "add" class = "btn me-10 btn-neutral">신규등록</a>
    </div>

    <div class = "cell">
        <table class = "table table-border table-hover table-sprited w-100 center">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>사진</th>
                    <th>이름</th>
                    <th>국어점수</th>
                    <th>영어점수</th>
                    <th>수학점수</th>
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
						<td><fmt:formatNumber value="${studentDto.getStudentAverage()}" pattern="#,##0.0"/></td>
	<%-- 				<td>${ studentDto.getStudentReg() }</td> --%>
						<td><fmt:formatDate value="${studentDto.getStudentReg()}" pattern="y년 M월 d일"/></td>
					</tr>
				</c:forEach>
			</tbody>
        </table>
    </div>

<%-- 페이지 네비게이터 출력 --%>
<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>