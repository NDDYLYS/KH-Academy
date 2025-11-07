<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class = "container w-600">
    <div class = "cell mb-30 center">
        <h1>도서 현황</h1>
    </div>

    <div class = "cell">
        <table class = "table table-hover table-sprited w-100 center">
            <thead>
                <tr>
					<th>도서장르</th>
					<th>권수</th>
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
    </div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>