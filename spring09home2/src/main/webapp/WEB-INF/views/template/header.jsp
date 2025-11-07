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
<!--     <link rel="stylesheet" type="text/css" href="/css/commons.css"> -->
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
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.8/flatly/bootstrap.min.css" rel="stylesheet">
     
    <script src = "/js/confirm.js"></script>
    
    <script type="text/javascript">
        $(function () {
            // Navbar에서 외부를 클릭하면 메뉴가 닫히게 구현
            $(document).on("click", function(e){
                //alert(e.target);
                var parent = $(e.target).closest(".navbar");              
                var valid1 = $(e.target).closest(".navbar-brand").length > 0;
                var valid2 = $(e.target).closest(".nav-link").length > 0;
                var valid3 = $(e.target).closest(".dropdown-item").length > 0;
                if (parent.length > 0 && (!valid1 && !valid2 && !valid3))
                    return;

                $("#menu-body").collapse("hide");
            });
        });
    </script>
</head>
<body>
   
   <nav class="navbar fixed-top navbar-expand-lg bg-primary" data-bs-theme="dark">
        <div class="container-fluid">
            <!-- 브랜드, 제일 좌측에 나오는 로고 -->
            <a class="navbar-brand" href="/">KH 정보교육원</a>

            <!-- 좁아진 상황에서 메뉴리스트가 나오는 토글 -->
            <!-- bootstrap.js에서 선택자를 통해 찾는다 -->
            <!-- data-bs-toggle은 버튼을 눌러서 수행할 수 있는 작업을 지정
                 data-bs-target은 버튼을 눌러서 제어할 대상의 선택자를 지정  -->
            <button class="navbar-toggler" 
                type="button" 
                data-bs-toggle="collapse" 
                data-bs-target="#menu-body"
                aria-controls="menu-body" 
                aria-expanded="false" 
                aria-label="Toggle navigation">
                <!-- ARIA는 시력 장애인 용도 -->
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- 콜랩스 영역. 좁은 화면일 경우 -->
            <div class="collapse navbar-collapse" id="menu-body">
            	<c:choose>
					<c:when test="${sessionScope.loginId != null && sessionScope.loginLevel == '일반회원'}">
						<!-- 좌측 메뉴 -->
		                <ul class="navbar-nav me-auto">
		                    <li class="nav-item">
		                        <a class="nav-link" href="/pokemon/list">
				                    <i class="fa-solid fa-ghost"></i>
									<span>포켓몬</span>
		                        </a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/student/list">
								    <i class="fa-solid fa-graduation-cap"></i>
								    <span>학생정보</span>
							    </a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/board/list">
									<i class="fa-solid fa-comments"></i>
									<span>게시판</span>
								</a>
		                    </li>
		                </ul>
					</c:when>
					<c:when test="${sessionScope.loginId != null && sessionScope.loginLevel == '우수회원'}">
						<!-- 좌측 메뉴 -->
		                <ul class="navbar-nav me-auto">
		                    <li class="nav-item">
		                        <a class="nav-link" href="/pokemon/list">
				                    <i class="fa-solid fa-ghost"></i>
									<span>포켓몬</span>
		                        </a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/student/list">
								    <i class="fa-solid fa-graduation-cap"></i>
								    <span>학생정보</span>
							    </a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/book/list">
								    <i class="fa-solid fa-book"></i>
								    <span>도서정보</span>
							    </a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/board/list">
									<i class="fa-solid fa-comments"></i>
									<span>게시판</span>
								</a>
		                    </li>
		                </ul>
					</c:when>
            		<c:when test="${sessionScope.loginId != null && sessionScope.loginLevel == '관리자'}">
            			<!-- 좌측 메뉴 -->
		                <ul class="navbar-nav me-auto">
		                    <li class="nav-item">
		                        <a class="nav-link" href="/pokemon/list">
				                    <i class="fa-solid fa-ghost"></i>
									<span>포켓몬</span>
		                        </a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/student/list">
								    <i class="fa-solid fa-graduation-cap"></i>
								    <span>학생정보</span>
							    </a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/book/list">
								    <i class="fa-solid fa-book"></i>
								    <span>도서정보</span>
							    </a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/board/list">
									<i class="fa-solid fa-comments"></i>
									<span>게시판</span>
								</a>
		                    </li>
		                </ul>
            		</c:when>
            		<c:otherwise>
            			<!-- 좌측 메뉴 -->
		                <ul class="navbar-nav me-auto">
		                    <li class="nav-item">
		                        <a class="nav-link" href="/pokemon/list">
				                    <i class="fa-solid fa-ghost"></i>
									<span>포켓몬</span>
		                        </a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/board/list">
									<i class="fa-solid fa-comments"></i>
									<span>게시판</span>
								</a>
		                    </li>
		                </ul>
            		</c:otherwise>
           		</c:choose>
           		
                <!-- 우측 메뉴 -->
                <ul class="navbar-nav">
                	<c:choose>
						<c:when test="${sessionScope.loginId == null}">
							<li class="nav-item">
		                        <a class="nav-link" href="/member/login">
									<i class="fa-solid fa-right-to-bracket"></i>
									<span>로그인</span>
								</a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/member/join">
									<i class="fa-solid fa-user-plus"></i>
									<span>회원가입</span>
								</a>
		                    </li>
						</c:when>
	            		<c:when test="${sessionScope.loginId != null && sessionScope.loginLevel == '관리자'}">
							<li class="nav-item">
		                        <a class="nav-link" href="/admin/home">
									<i class="fa-solid fa-wrench"></i>
									<span>관리메뉴</span>
								</a>
		                    </li>
			            	<li class="nav-item">
		                        <a class="nav-link" href="/giftcard/list">
									<i class="fa-solid fa-sack-dollar"></i>
									<span>충전</span>	
								</a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/member/mypage">
									<i class="fa-solid fa-user"></i>
									<span>마이페이지</span>
								</a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/member/logout">
									<i class="fa-solid fa-right-from-bracket"></i>
									<span>로그아웃</span>
								</a>
		                    </li>
	            		</c:when>
	            		<c:otherwise>
	            			<li class="nav-item">
		                        <a class="nav-link" href="/member/mypage">
									<i class="fa-solid fa-user"></i>
									<span>마이페이지</span>
								</a>
		                    </li>
		                    <li class="nav-item">
		                        <a class="nav-link" href="/member/logout">
									<i class="fa-solid fa-right-from-bracket"></i>
									<span>로그아웃</span>
								</a>
		                    </li>
	            		</c:otherwise>
	           		</c:choose>
                </ul>
            </div>
        </div>
    </nav>


    <!-- 컨테이너 -->
    <div class="container my-5 pt-5"> 