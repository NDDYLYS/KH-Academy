<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

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

<style>
    .move {
      width: 50px;
      height: 50px;
      position: relative;
      animation: moveBox 3s infinite alternate;
    }

    @keyframes moveBox {
      0%   { left: 0px; top: 0px; }
      50%  { left: 200px; top: 100px; }
      100% { left: 400px; top: 0px; }
    }
</style>

<style>
    .rotation {
      width: 100px;
      height: 100px;
      background: tomato;
      margin: 100px auto; /* 가운데 배치 */
      animation: spin 2s linear infinite;
    }

    @keyframes spin {
      from { transform: rotate(0deg); }
      to   { transform: rotate(360deg); }
    }
</style>

<style>
    .container {
      position: relative;
      display: inline-block;
    }
    .container img {
      display: block;
      width: 400px; /* 이미지 크기 */
    }
    .center-text {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%); /* 정확히 중앙 */
      color: white;
      font-size: 24px;
      font-weight: bold;
      text-shadow: 2px 2px 5px black; /* 가독성 ↑ */
    }
</style>
  
<style>
  #movingImage {
    position: absolute;
    width: 100px;
    height: 100px;
    animation: moveImage 5s linear infinite;
  }

  @keyframes moveImage {
    0% { left: 200px; top: 200px; }
    25% { left: 500px; top: 200px; }
    50% { left: 500px; top: 300px; }
    75% { left: 200px; top: 300px; }
    100% { left: 200px; top: 200px; }
  }
</style>
      
<marquee direction="right" scrollamount="5"><p>이 글자를 <span class="shake">쉐이크!</span></p></marquee>
<div class="move">
	<div class="center-text">
		<div class="rotation">날 잡아봐</div>
	</div>
</div>
<marquee direction="left" scrollamount="20"><p>널 납치하겠어! <span class="shake"><image src = "/images/naver-icon-style.png" width = "125"></span> </p></marquee>
<img id="movingImage" src="/images/kt.png" alt="움직이는 이미지">


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
