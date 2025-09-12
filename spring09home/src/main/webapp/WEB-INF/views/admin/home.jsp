<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<div class = "container w-400">
    <div class = "cell center">
        <h1>[관리 페이지]</h1>
    </div>
    <div class = "cell center">
        <h2><a href = "/admin/member/list" class = "btn btn-nuetral">[회원 관리]</a></h2>
    </div>
    <div class = "cell center">
        <h2><a href = "/admin/stat/pokemon" class = "btn btn-nuetral">[포켓몬 현황]</a></h2>
    </div>
    <div class = "cell center">
        <h2><a href = "/admin/stat/student" class = "btn btn-nuetral">[학생 현황]</a></h2>
    </div>
    <div class = "cell center">
        <h2><a href = "/admin/stat/book" class = "btn btn-nuetral">[도서 현황]</a></h2>
    </div>
    <div class = "cell center">
        <h2><a href = "/admin/stat/member" class = "btn btn-nuetral">[회원 현황]</a></h2>
    </div>
</div>
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>