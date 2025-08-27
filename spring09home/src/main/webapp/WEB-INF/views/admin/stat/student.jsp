<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<table border = "1" width = "350">
	<thead>
		<tr>
			<th>회원등급</th>
			<th>회원수</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var = "statVO" items = "${statList}">
			<tr>
				<td>${statVO.title}</td>
				<td><fmt:formatNumber value="${statVO.value}" pattern="#,##0"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>