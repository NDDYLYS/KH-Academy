<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- 점보트론(Jumbotron) : 페이지의 상단에 배치되는 제목 영역 -->
<div class="row">
    <div class="col">
        <div class="bg-dark text-light p-4 rounded">
            <h1>KH 정보교육원 수업자료</h1>
            <div>웹개발 과정 실습 수업자료 (Bootstrap 기반)</div>
        </div>
    </div>
</div>

<!-- 주요 컨텐츠들 -->
<div class="row mt-4">
    <!-- 최근 게시글 -->
   <div class="col-md-6 mb-4">
       <div class="d-flex justify-content-between">
           <h3>최근 게시글</h3>
           <a href="#" class="link-underline link-underline-opacity-0">더보기<i class="fa-solid fa-arrow-right"></i></a>
       </div>                        
       <hr>
       <ul class="list-group list-group-flush">
           <li class="list-group-item text-truncate">첫 번째 게시글</li>
           <li class="list-group-item text-truncate">두 번째 게시글</li>
           <li class="list-group-item text-truncate">세 번째 게시글</li>
           <li class="list-group-item text-truncate">네 번째 게시글</li>
           <li class="list-group-item text-truncate">다섯 번째 게시글</li>
       </ul>
   </div>
   <!-- 인기 게시글-->
   <div class="col-md-6 mb-4">
       <div class="d-flex justify-content-between">
           <h3>인기 게시글</h3>
           <a href="#" class="link-underline link-underline-opacity-0">더보기<i class="fa-solid fa-arrow-right"></i></a>
       </div>
       <hr>
       <ul class="list-group list-group-flush">
           <li class="list-group-item text-truncate">어쩌구저쩌구...</li>
           <li class="list-group-item text-truncate">어쩌구저쩌구...</li>
           <li class="list-group-item text-truncate">어쩌구저쩌구...</li>
           <li class="list-group-item text-truncate">어쩌구저쩌구...</li>
           <li class="list-group-item text-truncate">어쩌구저쩌구...</li>
       </ul>
   </div>
   <!-- 명예의 전당 -->
   <div class="col-md-6 mb-4">
       <div class="d-flex justify-content-between">
           <h3>명예의 전당</h3>
           <a href="#" class="link-underline link-underline-opacity-0">더보기<i class="fa-solid fa-arrow-right"></i></a>
       </div>
       <hr>
       <ul class="list-group list-group-flush">
           <li class="list-group-item d-flex justify-content-between">
               <div>
                   <span class="badge text-bg-primary">1</span> 
                   <span class="ms-4">피카츄</span>
               </div>
               <div>15,000 point</div>
           </li>
           <li class="list-group-item d-flex justify-content-between">
               <div>
                   <span class="badge text-bg-secondary">2</span> 
                   <span class="ms-4">꼬부기</span>
               </div>
               <div>12,030 point</div>
           </li>
           <li class="list-group-item d-flex justify-content-between">
               <div>
                   <span class="badge text-bg-secondary">3</span> 
                   <span class="ms-4">홍길동</span>
               </div>
               <div>11,077 point</div>
           </li>
           <li class="list-group-item d-flex justify-content-between">
               <div>
                   <span class="badge text-bg-secondary">4</span> 
                   <span class="ms-4">닌자</span>
               </div>
               <div>8,560 point</div>
           </li>
           <li class="list-group-item d-flex justify-content-between">
               <div>
                   <span class="badge text-bg-secondary">5</span> 
                   <span class="ms-4">사무라이</span>
               </div>
               <div>5,253 point</div>
           </li>
       </ul>
   </div>
   <!-- 포켓몬 순위 -->
    <div class="col-md-6 mb-4">
        <div class="d-flex justify-content-between">
            <h3>포켓몬 랭킹</h3>
            <a href="#" class="link-underline link-underline-opacity-0">더보기<i class="fa-solid fa-arrow-right"></i></a>
        </div>
        <hr>
        <ul class="list-group list-group-flush">
            <li class="list-group-item d-flex justify-content-between">
                <div class="text-start">
                    <span class="badge text-bg-primary">1</span> 
                    <span class="ms-4">피카츄</span>
                </div>
                <div class="text-end">
                    <i class="fa-solid fa-heart text-danger"></i>
                    <span class="ms-1">702</span>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between">
                <div class="text-start">
                    <span class="badge text-bg-secondary">2</span> 
                    <span class="ms-4">라이츄</span>
                </div>
                <div class="text-end">
                    <i class="fa-solid fa-heart text-danger"></i>
                    <span class="ms-1">568</span>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between">
                <div class="text-start">
                    <span class="badge text-bg-secondary">3</span> 
                    <span class="ms-4">뮤츠</span>
                </div>
                <div class="text-end">
                    <i class="fa-solid fa-heart text-danger"></i>
                    <span class="ms-1">277</span>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between">
                <div class="text-start">
                    <span class="badge text-bg-secondary">4</span> 
                    <span class="ms-4">꼬부기</span>
                </div>
                <div class="text-end">
                    <i class="fa-solid fa-heart text-danger"></i>
                    <span class="ms-1">100</span>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between">
                <div class="text-start">
                    <span class="badge text-bg-secondary">5</span> 
                    <span class="ms-4">마자용</span>
                </div>
                <div class="text-end">
                    <i class="fa-solid fa-heart text-danger"></i>
                    <span class="ms-1">77</span>
                </div>
            </li>
        </ul>
    </div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>