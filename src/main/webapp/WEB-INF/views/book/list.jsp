<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class = "container w-850">
    <div class = "cell mb-30 center">
        <h1>도서 목록</h1>
    </div>

    <div class = "cell left">
        <form autocomplete="off">
            <select name = "column" class = "field">
                <option value="book_title" ${param.column == "book_title" ? "selected" : ""}>책 제목</option>
                <option value="book_author" ${param.column == "book_author" ? "selected" : ""}>저자</option>
                <option value="book_publisher" ${param.column == "book_publisher" ? "selected" : ""}>출판사</option>
            </select>
            <input type ="search" name="keyword" value = "${param.keyword}" class = "field" required>
            <Button type = "submit" class = "btn btn-positive">검색</Button>
        </form>
    </div>

    <div class = "cell right">
        <a href = "save" class = "btn me-10  btn-neutral">신규등록</a>
    </div>

    <div class = "cell">
        <table class = "table table-border table-hover table-sprited w-100 center">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>표지</th>
                    <th>이름</th>
                    <th>저자</th>
                    <th>출판사</th>
                    <th>장르</th>
                    <th>출간일</th>
                    <th>가격</th>
                    <th>페이지 수</th>
                </tr>
            </thead>

            <tbody align = "center">
				<c:forEach var = "bookDto" items = "${ bookList }">
					<tr>
                        <td>${ bookDto.getBookId() }</td>
                        <td><img src = "/book/image?bookId=${bookDto.getBookId()}" width="32" height = "32"></td>
                        <td><a href="detail?bookId=${bookDto.getBookId()}">${ bookDto.getBookTitle() }</a></td>
                        <td>${ bookDto.getBookAuthor() }</td>
                        <td>${ bookDto.getBookPublisher() }</td>
                        <td>${ bookDto.getBookGenre() }</td>
                        <td>${ bookDto.getBookPublicationDate() }</td>
                        <td align = "right"><fmt:formatNumber value="${bookDto.getBookPrice()}" pattern="#,##0"/></td>
                        <td align = "right">${ bookDto.getBookPageCount() }</td>
					</tr>
				</c:forEach>
			</tbody>
            	<tfoot>
                    <tr>
                        <td colspan="7">
                            검색결과 : 
                            ${pageVO.begin} - ${pageVO.end}
                            /
                            ${pageVO.dataCount}개
                        </td>
                    </tr>
                </tfoot>
        </table>
    </div>
</div>

<%-- 페이지 네비게이터 출력 --%>
<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>