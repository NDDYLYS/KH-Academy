<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<form action="/add" method="post">
  <input type="text" name="clientId" placeholder="클라이언트 ID" required> <br><br>
  <input type="password" name="clientPassword" placeholder="클라이언트 PW" required> <br><br>
  <input type="text" name="clientNickname" placeholder="클라이언트 닉네임" required> <br><br>
  <select name="clientGrade" required>
    <option value="">선택하세요</option>
    <option>일반</option>
    <option>우수</option>
    <option>VIP</option>
    <option>관리자</option>
  </select><br><br>
  <button type="button">등록</button>
</form>