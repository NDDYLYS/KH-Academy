<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>${memberDto.memberId}님의 정보</h1>

<table border="1" width="500">
	<tr>
        <th>프로필</th>
        <td><img src = "/member/profile?memberId=${memberDto.getMemberId()}"
         width="200" height = "200"></td>
    </tr>
	<tr>
		<th>닉네임</th>
		<td>${memberDto.memberNickname}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>가입일</th>
		<td>
			<fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월"/>
		</td>
	</tr>
</table>

<h1>나의 글 작성 내역</h1>

<table border = "1" width = "500">
	<thead>
		<th>제목</th>
		<th>작성일</th>
	</thead>
	<tbody>
		<c:forEach var = "boardListVO" items = "${ boardList }">
			<tr>
				<td><a href = "/board/detail?boardNo=${boardListVO.boardNo }">${ boardListVO.boardTitle }</a></td>
				<td>${ boardListVO.boardWtime }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<h1>나의 상품권 구매 내역</h1>

<table border = "1" width = "500">
	<thead>
		<th>번호</th>
		<th>구매지</th>
		<th>상품번호</th>
		<th>상품이름</th>
		<th>수량</th>
		<th>금액</th>
	</thead>
	<tbody>
		<c:forEach var = "buyDto" items = "${ buyList }">
			<tr>
				<td>${ buyDto.buyNo }</td>
				<td>${ buyDto.buyMemberId }</td>
				<td>${ buyDto.buyGiftcardNo }</td>
				<td>${ buyDto.buyGiftcardName }</td>
				<td>${ buyDto.buyQty }</td>
				<td>${ buyDto.buyAmount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


