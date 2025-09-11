<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form autocomplete="off" action="./join" method="post" enctype="multipart/form-data">
    <div class="container w-600">
        <div class="cell center">
            <h1>회원 가입 정보 입력</h1>
        </div>
        <div class="cell">
            <label>아이디 <span class="red">*</span></label>
            <input type="text" name="memberId" placeholder="영문 소문자로 시작하며 숫자 포함 5~20자" 
                        class="field w-100" required>
        </div>
        <div class="cell">
            <label>비밀번호 <span class="red">*</span></label>
            <input type="password" name="memberPw" placeholder="대소문자, 숫자, 특수문자를 반드시 포함한 8~16자" 
                        class="field w-100" required>
        </div>
        <div class="cell">
            <label>닉네임 <span class="red">*</span></label>
            <input type="text" name="memberNickname" placeholder="한글 또는 숫자 2~10자" 
                required class="field w-100">
        </div>
        <div class="cell">
            <label>이메일 <span class="red">*</span></label>
            <input type="email" inputmode="email" name="memberEmail" placeholder="test@kh.com"
                required class="field w-100">
        </div>
        <div class="cell">
            <label>생년월일</label>
            <input type="date" name="memberBirth" class="field w-100">
        </div>
        <div class="cell">
            <label>연락처</label>
            <input type="tel" inputmode="tel" name="memberContact" class="field w-100"
                    placeholder="010XXXXXXXX (- 제외하고 작성)">
        </div>
        <div class="cell">
            <label style="display: block;">주소</label>
            <input type="text" name="memberPost" placeholder="우편번호" class="field"
                        size="6">
            <button type="button" class="btn btn-neutral">검색</button>
        </div>
        <div class="cell">
            <input type="text" name="memberAddress1" placeholder="기본주소" class="field w-100">
        </div>
        <div class="cell">
            <input type="text" name="memberAddress2" placeholder="상세주소" class="field w-100">
        </div>
        <div class="cell">
            <label>프로필 이미지(선택)</label>
            <input type="file" name="attach" accept="image/*" class="field w-100">
        </div>
        <div class="cell mt-30">
            <button type="submit" class="btn btn-positive w-100">회원 가입하기</button>
        </div>
    </div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>