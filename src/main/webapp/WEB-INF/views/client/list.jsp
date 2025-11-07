<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table border="1" width="600">
  <thead>
    <tr>
      <th>아이디</th>
      <th>닉네임</th>
      <th>등급</th>
      <th>가입일</th>
      <th>포인트</th>
    </tr>
  </thead>
  <tbody>  
    <c:forEach var="clientDto" items="${clientList}">
	    <tr>
	      <td>${clientDto.clientId}</td>
	      <td>${clientDto.clientNickname}</td>
	      <td>${clientDto.clientGrade}</td>
	      <td>
	        <fmt:formatDate value="${clientDto.clientJoin}" pattern="yyyy-MM-dd"/>
	      </td>
	      <td>
	        <fmt:formatNumber value="${clientDto.clientPoint}" pattern="#,##0"/>
	      </td>
	    </tr>
	 </c:forEach>
  </tbody>
</table>