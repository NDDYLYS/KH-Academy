<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
 
<h1>회원 상세정보</h1>

<a href = "list">회원 목록보기</a>

<table border = "1" width = "900">
	<tr>
		<th>아이디</th>
      	<td>${memberDto.getMemberId()}</td>
	</tr>
	<tr>
        <th>프로필</th>
        <td><img src = "/member/profile?memberId=${memberDto.getMemberId()}"
         width="200" height = "200"></td>
    </tr>
	<tr>
		<th>닉네임</th>
		<td>${memberDto.getMemberNickname()}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>생일</th>
		<td>${memberDto.getMemberBirth()}</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${memberDto.getMemberLevel()}</td>
	</tr>
	<tr>
        <th>가입일</th>
        <td>
        	<fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월 d일 H시 m분 s초"/>
        </td>
    </tr>
    <tr>
        <th>최종로그인</th>
        <td>
        	<fmt:formatDate value="${memberDto.memberLogin}" pattern="y년 M월 d일 H시 m분 s초"/>
        </td>
    </tr>
    <tr>
        <th>비밀번호 변경일</th>
        <td>
        	<fmt:formatDate value="${memberDto.memberChange}" pattern="y년 M월 d일 H시 m분 s초"/>
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

<h2><a href = "/admin/crud/edit?memberId=${memberDto.memberId}"">정보 수정</a></h2>
<h2><a href = "/admin/crud/password?memberId=${memberDto.memberId}"">비밀번호 수정</a></h2>
<h2><a href = "/admin/crud/drop?memberId=${memberDto.memberId}">강퇴</a></h2>
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>