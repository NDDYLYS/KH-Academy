<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<h1>[관리 페이지]</h1>
    
<h2><a href = "/admin/member/list">[회원 관리]</a></h2>
<h2><a href = "/admin/status/pokemon">[포켓몬 현황]</a></h2>
<h2><a href = "/admin/status/student">[학생 현황]</a></h2>
<h2><a href = "/admin/status/book">[도서 현황]</a></h2>
<h2><a href = "/admin/status/member">[회원 현황]</a></h2>
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>