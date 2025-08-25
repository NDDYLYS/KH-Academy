<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>글자 쉐이크 효과</title>
<style>
  .shake {
    display: inline-block;
    font-size: 24px;
    font-weight: bold;
    animation: shakeAnimation 0.5s infinite; /* 0.5초마다 반복 */
  }

  @keyframes shakeAnimation {
    0% { transform: scale(1); }
    25% { transform: scale(1.2); }
    50% { transform: scale(0.8); }
    75% { transform: scale(1.2); }
    100% { transform: scale(1); }
  }
</style>
</head>
<body>

<marquee direction="right" scrollamount="5"><p>이 글자를 <span class="shake">쉐이크!</span></p></marquee>
<marquee direction="left" scrollamount="5"><p>이 글자를 <span class="shake">쉐이크!</span></p></marquee>



</body>
</html>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
