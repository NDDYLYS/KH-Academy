<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class = "container w-1100">
    <div class = "cell">
        <h1>멘션형 자유 게시판</h1>
    </div>
    <div class = "cell">
        <table class = "table table-hover table-sprited w-100 center">
            <c:forEach var="boardListVO" items="${boardList}" varStatus="status">
                <tr bgcolor="${status.index < noticeCount ? '#ffeaa7' : ''}">
                    <td>
                    No.${ boardListVO.boardNo } 
                    (${boardListVO.memberNickname == null ? '탈퇴한 사용자':boardListVO.memberNickname})
                    <br><br> 
                    <c:if test = "${boardListVO.boardDepth > 0 }">
                        @${ boardListVO.originWriter } - ${ boardListVO.originTitle }<br>
                    </c:if>
                    <a href="detail?boardNo=${ boardListVO.boardNo }">${ boardListVO.boardTitle }</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>