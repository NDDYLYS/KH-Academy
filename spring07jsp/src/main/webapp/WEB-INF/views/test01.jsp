<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
 JSP 
 - Java Server Page(자바를 기반으로 만든 화면)
 - 자바 코드와 html을 섞어서 사용 가능
 - html을 먼저 배우고 자바 코드를 섞는 방법을 배운다
 - 맨 위에 작성되는 것은 지우면 안된다
 - (MIME-TYPE, text/html, video/mp4, text/plain, 대분류/소분류)
 - contentType은 사용자가 받을 화면의 형태를 저장한다
 - pageEncoding은 내부적으류 변환할 때 적용시킬 글자셋을 의미
--%>>

<h1>1번 예제</h1>

<%--
Hyper Text Markup Language
- text끼리 얽힌 게 Hyper Text
- 태그. 미리 정의된 tag를 이용하여 구현(지정된 영역에 정해진 효과 부여)
- a 태그는 클릭하면 다른 페이지로 이동하는 하이퍼태그
- 태그 만으로 정보가 부족할 때 속성을 사용하여 추가 정보를 제공
--%>

아무런 태그 없이 작성한 일반 글자
<h1><a href = "https://naver.com">태그로 감싼 글자</a></h1>
<h2><a href = "https://naver.com">태그로 감싼 글자</a></h2>
<h3><a href = "https://naver.com">태그로 감싼 글자</a></h3>
<hr>
<h4><a href = "https://naver.com">태그로 감싼 글자</a></h4>
<h5><a href = "https://naver.com">태그로 감싼 글자</a></h5>
<h6><a href = "https://naver.com">태그로 감싼 글자</a></h6>
<marquee direction="left" scrollamount="5">
<a href = "https://naver.com">
  흐르는 글자 예시
</a>
</marquee>
<marquee direction="right" scrollamount="5">
<a href = "https://naver.com">
  흐르는 글자 예시2
</a>
</marquee>
<a href = "https://naver.com">네이버로 이동</a>
<a href = "http://localhost:8080/hello">hello로 이동</a>
<a href = "./hello">hello로 이동</a>
<a href = "hello">hello로 이동</a>
