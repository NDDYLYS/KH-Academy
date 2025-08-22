<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원 정보 입력</h1>

<form action = "./join" method = "post">
<input type = "text" name = "memberId" placeholder = "아이디를 입력하세요." required>
<input type = "password" name = "memberPw" placeholder = "비밀번호를 입력하세요." required>
<input type = "text" name = "memberNickname" placeholder = "닉네임을 입력하세요." required>
<input type = "text" name = "memberEmail" placeholder = "이메일을 입력하세요." required inputmode = "email">
<input type = "date" name = "memberBirth">
<input type = "text" name = "memberContact" placeholder = "전화번호를 입력하세요." inputmode = "tel">
<input type = "text" name = "memberPost" placeholder = "우편주소를 입력하세요." size = "6">
<br>
<input type = "text" name = "memberAddress1" placeholder = "기본주소를 입력하세요." size = "60">
<br>
<input type = "text" name = "memberAddress2" placeholder = "상세주소를 입력하세요." size = "60">
<!-- <input type = "text" name = "memberJoin" placeholder = "가입시간을 입력하세요."> -->
<!-- <input type = "text" name = "memberLogin" placeholder = "로그인시간을 입력하세요."> -->
<!-- <input type = "text" name = "memberChange" placeholder = "변경시간을 입력하세요."> -->
<button>회원가입</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>