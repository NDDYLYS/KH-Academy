<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<h3>글 번호 : ${boardDto.boardNo }, 작성자 : ${boardDto.boardWriter }</h3>
<h1>글 제목 : ${boardDto.boardTitle }</h1>
<h1>본문 : ${boardDto.boardContent }</h1>
<h3>조회수 : ${boardDto.boardRead }, 좋아요 : ${boardDto.boardLike }</h3>
<h5>작성일 : <fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm:ss"/>, 수정일 : <fmt:formatDate value="${boardDto.boardEtime}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>


<%-- <a href = "/board/like?boardNo=${boardDto.boardNo}" style="float: left;"> [좋아요] </a> --%>
<a href = "/board/delete?boardNo=${boardDto.boardNo}" style="float: right;"> [삭제] </a>
<a href = "/board/update?boardNo=${boardDto.boardNo}" style="float: right;"> [수정] </a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>