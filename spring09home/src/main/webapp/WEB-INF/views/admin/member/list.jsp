<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class = "container w-500">
    <div class = "cell">
        <h1>회원 검색</h1>
    </div>
    <div class = "cell">
        <form action="list" method="get">
            <select name="column" class = "field">
                <option value="member_id" ${param.column == "member_id" ? "selected" : ""}>아이디</option>
                <option value="member_nickname" ${param.column == "member_nickname" ? "selected" : ""}>닉네임</option>
                <option value="member_email" ${param.column == "member_email" ? "selected" : ""}>이메일</option>
                <option value="member_contact" ${param.column == "member_contact" ? "selected" : ""}>연락처</option>
                <option value="member_level" ${param.column == "member_level" ? "selected" : ""}>등급</option>
            </select>	
            <%-- param이라는 도구를 이용하면 파라미터를 직접 불러올 수 있다 --%>
            <input class = "field" type="text" name="keyword" value="${param.keyword}" required>
            <button type = "submit" class = "btn btn-nuetral">검색</button>
        </form>
        </div>
        <div class = "cell">
            <!-- 결과 -->
        <c:choose>
        <c:when test="${memberList == null}">
            <h3>검색어를 입력하세요</h3>
        </c:when>
            <c:otherwise>
                <table class = "table table-hover table-sprited w-100 center">
                    <thead>
                        <tr>
                            <th>아이디</th>
                            <th>닉네임</th>
                            <th>이메일</th>
                            <th>생년월일</th>
                            <th>연락처</th>
                            <th>등급</th>
                            <th>가입일</th>
                        </tr>
                    </thead>
                    <tbody align="center">
                        <c:forEach var="memberDto" items="${memberList}" varStatus = "status">
                            <tr bgcolor = "${ status.count % 5 == 0 ? '#ffeaa7' : '' }">
                                <td>
                                    <a href="detail?memberId=${memberDto.memberId}">
                                        ${memberDto.memberId}
                                    </a>
                                </td>
                                <td>${memberDto.memberNickname}</td>
                                <td>${memberDto.memberEmail}</td>
                                <td>${memberDto.memberBirth}</td>
                                <td>${memberDto.memberContact}</td>
                                <td>${memberDto.memberLevel}</td>
                                <td>
                                    <fmt:formatDate value="${memberDto.memberJoin}" pattern="yyyy-MM-dd"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="7">
                                검색결과 : 
                                ${pageVO.begin} - ${pageVO.end}
                                /
                                ${pageVO.dataCount}개
                            </td>
                        </tr>
                    </tfoot>	
                </table>
                
                <%-- 페이지 네비게이터 출력 --%>
                <jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>
            
            </c:otherwise>
        </c:choose>
    </div>
</div>
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

