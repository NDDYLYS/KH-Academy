<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<form autocomplete="off" action="edit" method="post" enctype="multipart/form-data">
    <div class="container w-600">
        <div class="cell center">
            <h1>회원 정보 수정</h1>
        </div>

        <div class="cell">
            <label>닉네임 <span class="red">*</span></label>
            <input type="text" name="memberNickname" placeholder="한글 또는 숫자 2~10자" 
                required class="field w-100" value="${memberDto.memberNickname}">
        </div>
        <div class="cell">
            <label>이메일 <span class="red">*</span></label>
            <input type="email" inputmode="email" name="memberEmail" placeholder="test@kh.com"
                required class="field w-100" value="${memberDto.memberEmail}">
        </div>
        <div class = "cell">
        		<select name = "memberLevel">
					<option ${memberDto.memberLevel == '일반회원' ? 'selected' : ''}>일반회원</option>
					<option ${memberDto.memberLevel == '우수회원' ? 'selected' : ''}>우수회원</option>
				</select>
        </div>
        <div class="cell">
            <label>생년월일</label>
            <input type="date" name="memberBirth" class="field w-100" value="${memberDto.memberBirth}">
        </div>
        <div class="cell">
            <label>연락처</label>
            <input type="tel" inputmode="tel" name="memberContact" class="field w-100"
                    placeholder="010XXXXXXXX (- 제외하고 작성)" value="${memberDto.memberContact}">
        </div>
        <div class="cell">
            <label style="display: block;">주소</label>
            <input type="text" name="memberPost" placeholder="우편번호" class="field"
                        size="6" value="${memberDto.memberPost}">
            <button type="button" class="btn btn-neutral">검색</button>
        </div>
        <div class="cell">
            <input type="text" name="memberAddress1" placeholder="기본주소" class="field w-100" value="${memberDto.memberAddress1}">
        </div>
        <div class="cell">
            <input type="text" name="memberAddress2" placeholder="상세주소" class="field w-100" value="${memberDto.memberAddress2}">
        </div>
        <div class="cell">
            <label>프로필 이미지(선택)</label>
            <input type="file" name="attach" accept="image/*" class="field w-100">
        </div>
        <div class="cell">
          	<label>확인용 비밀번호</label>
			<input type = "password" name = "memberPw" value = "" required  placeholder = "확인용 비밀번호">
        </div>
        <div class="cell mt-30">
            <button type="submit" class="btn btn-positive w-100">회원 정보 수정하기</button>
        </div>
    </div>
</form>

    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>