<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내가 만든 홈페이지</title>
    <link rel="stylesheet" type="text/css" href="/css/commons.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css">
    <style>
        .image-profile {
            border-radius: 50%;
            box-shadow: 0 0 3px 1px #636e72;
            opacity: 0.95;
            /* transition: opacity 0.1s ease-out; */
            transition-property: opacity, box-shadow;
            transition-duration: 0.1s;
            transition-timing-function: ease-out;
        }
        .image-profile:hover {
            opacity: 1;
        }
    </style>
    <!-- jquery cdn -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- momentjs CDN-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/locale/ko.min.js"></script>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.8/flatly/bootstrap.rtl.min.css" rel="stylesheet">
     
    <script src = "/js/confirm.js"></script>
</head>
<body>
    <!-- 고정된 컨테이너 생성 -->
    <div class="container w-1100 flex-box flex-vertical">

        <!-- 헤더(Header) -->
        <div class="flex-box">
            <div class="w-25 flex-box flex-center">
                <img src="/images/other/logo.svg">
            </div>
            <div class="w-50 center">
                <h1>KH정보교육원 스프링개발자 수업자료</h1>
            </div>
            <div class="w-25 center">
                <h2 class="mb-0">24시간 상담</h2>
                <p class="mt-0">1588-0000</p>
            </div>
        </div>
        
        <!-- 메뉴(Nav) 시작 -->
        <div>
            <div class="menu">
            
            	<%-- 템플릿 페이지에서 작성하는 경로는 반드시 절대경로여야 한다 --%>
				<%-- 로그인 여부에 따라 다른 메뉴들을 표시 --%>
				<c:choose>
					<c:when test="${sessionScope.loginId != null && sessionScope.loginLevel == '일반회원'}">
						<a href="/">
							<i class="fa-solid fa-house"></i>
							<span>홈</span>
						</a>
						<a href="/pokemon/list">
		                    <i class="fa-solid fa-ghost"></i>
							<span>포켓몬</span>
						</a>
						<a href="/student/list">
							<i class="fa-solid fa-graduation-cap"></i>
							<span>학생정보</span>
						</a>
						<a href="/board/list">
							<i class="fa-solid fa-comments"></i>
							<span>게시판</span>
						</a>
						
						<div class="divider"></div>
						
						<a href="/giftcard/list">
							<i class="fa-solid fa-sack-dollar"></i>
							<span>충전</span>	
						</a>
						<a href="/member/mypage">
							<i class="fa-solid fa-user"></i>
							<span>내정보</span>
						</a>
						<a href="/member/logout">
							<i class="fa-solid fa-right-from-bracket"></i>
							<span>로그아웃</span>
						</a>
					</c:when>
					<c:when test="${sessionScope.loginId != null && sessionScope.loginLevel == '우수회원'}">
						<a href="/">
							<i class="fa-solid fa-house"></i>
							<span>홈</span>
						</a>
						<a href="/pokemon/list">
		                    <i class="fa-solid fa-ghost"></i>
							<span>포켓몬</span>
						</a>
						<a href="/student/list">
							<i class="fa-solid fa-graduation-cap"></i>
							<span>학생정보</span>
						</a>
						<a href="/book/list">
							<i class="fa-solid fa-book"></i>
							<span>도서정보</span>
						</a>
						<a href="/board/list">
							<i class="fa-solid fa-comments"></i>
							<span>게시판</span>
						</a>
						
						<div class="divider"></div>
						
						<a href="/giftcard/list">
							<i class="fa-solid fa-sack-dollar"></i>
							<span>충전</span>	
						</a>
						<a href="/member/mypage">
							<i class="fa-solid fa-user"></i>
							<span>내정보</span>
						</a>
						<a href="/member/logout">
							<i class="fa-solid fa-right-from-bracket"></i>
							<span>로그아웃</span>
						</a>
					</c:when>
            		<c:when test="${sessionScope.loginId != null && sessionScope.loginLevel == '관리자'}">
            			<a href="/">
							<i class="fa-solid fa-house"></i>
							<span>홈</span>
						</a>
						<a href="/pokemon/list">
		                    <i class="fa-solid fa-ghost"></i>
							<span>포켓몬</span>
						</a>
						<a href="/student/list">
							<i class="fa-solid fa-graduation-cap"></i>
							<span>학생정보</span>
						</a>
						<a href="/book/list">
							<i class="fa-solid fa-book"></i>
							<span>도서정보</span>
						</a>
						<a href="/board/list">
							<i class="fa-solid fa-comments"></i>
							<span>게시판</span>
						</a>
						
						<div class="divider"></div>
						
						<a href="/admin/home" class="red">
							<i class="fa-solid fa-wrench"></i>
							<span>관리메뉴</span>
						</a>
						<a href="/member/logout">
							<i class="fa-solid fa-right-from-bracket"></i>
							<span>로그아웃</span>
						</a>
            		</c:when>
            		<c:otherwise>
            			<a href="/">
							<i class="fa-solid fa-house"></i>
							<span>홈</span>
						</a>
						<a href="/pokemon/list">
		                    <i class="fa-solid fa-ghost"></i>
							<span>포켓몬</span>
						</a>
						<a href="/board/list">
							<i class="fa-solid fa-comments"></i>
							<span>게시판</span>
						</a>
		
						<div class="divider"></div>
										
						<a href="/giftcard/list">
							<i class="fa-solid fa-sack-dollar"></i>
							<span>충전</span>	
						</a>
						<a href="/member/login">
							<i class="fa-solid fa-right-to-bracket"></i>
							<span>로그인</span>
						</a>
						<a href="/member/join">
							<i class="fa-solid fa-user-plus"></i>
							<span>회원가입</span>
						</a>
            		</c:otherwise>
           		</c:choose>
            </div>
        </div>
        <!-- 메뉴 종료 -->

        <!-- 컨텐츠 -->
        <div class="flex-box" style="min-height: 400px;">

            <!-- 사이드바(생략가능) -->
            <div class="w-200">
            
            	<c:choose>
					<c:when test="${sessionScope.loginId != null}">
						<!-- 로그인 상태일 때 -->
		                <div class="cell center">
		                    <img src="/member/profile?memberId=${sessionScope.loginId}" width="150" height="150"
		                                class="image-profile">
		                </div>
		                <div class="cell center">
		                    <h3>
								${sessionScope.loginId}
								(${sessionScope.loginLevel})
							</h3>
		                </div>
		                <div class="cell center">
		                    <a href="/member/mypage">
		                        <i class="fa-solid fa-user"></i>
		                        <span>내 정보 보기</span>
		                    </a>
		                </div>
					</c:when>
					<c:otherwise>
						<!-- 로그인 하지 않았을 때 -->
		                <div class="cell center">
		                    <h3>비회원 상태</h3>
		                </div>
		                <div class="cell center">
		                    <a href="/member/login">
		                        <i class="fa-solid fa-right-to-bracket fa-fade"></i>
		                        <span>로그인</span>
		                    </a>
		                </div>
		                <div class="cell center">
		                    <a href="/member/join">
		                        <i class="fa-solid fa-user-plus fa-fade"></i>
		                        <span>회원가입</span>
		                    </a>
		                </div>
					</c:otherwise>
				</c:choose>
                
            </div>

            <!-- 섹션 -->
            <div class="flex-fill">    