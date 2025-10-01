<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
	.profile-wrapper {
		width:200px;
		height:200px;
		position: relative;
		border-radius: 50%;
		overflow: hidden;
	}
	.profile-wrapper > img {
		width:100%;
		height:100%;
	}
	.profile-wrapper > label {
		position:absolute;
		top:0; 		left:0; 		right:0; 		bottom:0;
		background-color: rgba(0, 0, 0, 0.3);
		color:white;
		display: none;
		cursor:pointer;
	}
	.profile-wrapper:hover > label {
		display:flex;
	}
</style>

<!-- 프로필 변경 코드 -->
<script type="text/javascript">
	$(function(){
		//이미지의 최초 주소를 불러와서 저장한다
		var origin = $(".image-profile").attr("src");
		
		//$(".profile-change-btn").on("click", function(){
		$("#profile-input").on("input", function(){
			//선택된 파일을 구해와서
			//var list = document.querySelector(".profile-input").files;//JS
			var list = $("#profile-input").prop("files");//jQuery
			if(list.length == 0) return;
			
			//비동기 통신으로 전송
			//- ajax도 form처럼 아무말 안하면 urlencoded 방식으로 전송(key=value)
			//- 파일은 multipart 방식으로 보내야 하기 때문에 기본 설정을 제거
			//- processData, contentType을 제거하고 FormData를 생성해서 전달
			var form = new FormData();//<form> 역할
			//form.append("이름", 값);
			form.append("attach", list[0]);
			
			$.ajax({
				processData : false,//multipart로 보내기 위해 미리 정의된 전처리 제거
				contentType : false,//multipart로 보내기 위해 미리 정의된 MIME 타입을 제거
				url:"/rest/member/profile",
				method:"post",
				data: form,
				success:function(response){
					//origin에 시간을 붙여서 src를 재설정
					//(중요) 브라우저의 캐싱을 우회하기 위하여 시간을 파라미터로 첨부
					var newOrigin = origin + "&t=" + new Date().getTime();
					$(".image-profile").attr("src", newOrigin);
				}
			});
		});
		
		$(".profile-delete").on("click", function(){
			var choice = window.confirm("정말 삭제?");
			if (choice == false)
				return;
			$.ajax({
				url:"/rest/member/delete",
				method:"post",
				success:function(response){
					var newOrigin = origin + "&t=" + new Date().getTime();
					$(".image-profile").attr("src", newOrigin);
				}
			});
		});
	});
</script>

<h1>${memberDto.memberId}님의 정보</h1>

<div class="profile-wrapper">
	<img class="image-profile" src="/member/profile?memberId=${memberDto.memberId}" width="200" height="200">
	<label for="profile-input" class="flex-box flex-center">변경</label>
</div>
<input type="file" id="profile-input" style="display:none">
<button type = "button" class = "profile-delete">프로필 삭제</button>

<br><br>

<table border="1" width="500">
	<tr>
		<th>닉네임</th>
		<td>${memberDto.memberNickname}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>${memberDto.memberBirth}</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${memberDto.memberContact}</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>포인트</th>
		<td>${memberDto.memberPoint}포인트</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
			<c:if test="${memberDto.memberPost != null}">
			[${memberDto.memberPost}] 
			${memberDto.memberAddress1} 
			${memberDto.memberAddress2}
			</c:if>
		</td>
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

<hr>

<%-- 나의 글 작성 이력 --%>
<h1>나의 글 작성 내역</h1>

<table border="1" width="500">
	<thead>
		<tr>
			<th>제목</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="boardListVO" items="${boardList}">
		<tr>
			<td>
				<a href="/board/detail?boardNo=${boardListVO.boardNo}">${boardListVO.boardTitle}</a>
			</td>
			<td>
				<fmt:formatDate value="${boardListVO.boardWtime}" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<hr>

<%-- 나의 포인트 구매내역 --%>
<h1>나의 포인트 구매내역</h1>

<table border="1" width="500">
	<thead>
		<tr>
			<th>상품명</th>
			<th>수량</th>
			<th>금액</th>
			<th>일시</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="buyDto" items="${buyList}" varStatus="status">
		<tr>
			<td>${buyDto.buyGiftcardName}</td>
			<td>${buyDto.buyQty}</td>
			<td>${buyDto.buyAmount}</td>
			<td>
				<fmt:formatDate value="${buyDto.buyTime}" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>


<hr>
<h2><a href="password">비밀번호 변경</a></h2>
<h2><a href="edit">내 정보 변경</a></h2>
<h2><a href="drop">회원 탈퇴하기</a></h2>
<!-- <h2><a href="/member/drop">회원 탈퇴하기</a></h2> -->

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>