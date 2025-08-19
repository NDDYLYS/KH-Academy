<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <h1>입력창 만들기</h1> -->

<!-- <form action = "https://genie.co.kr/search/searchMain"> -->
<!-- <input name = "query"> -->
<!-- <button>전송</button> -->
<!-- </form> -->

<!-- <hr> -->

<!-- <h1>유튜브 검색창</h1> -->

<!-- <form action = "https://www.youtube.com/results"> -->
<!-- <input name = "search_query"> -->
<!-- <button>검색</button> -->
<!-- </form> -->

<!-- <hr> -->

<!-- <h1>Github 검색창</h1> -->

<!-- <form action = "https://github.com/search"> -->
<!-- <input name = "q" placeholder = "자동으로 써있는 문구"> -->
<!-- <input type = "hidden" name = "type" value = "repositories"> -->
<!-- <button>검색</button> -->
<!-- </form> -->

<!-- select는 보기(option)를 주고 그 중에서 선택하여 입력한다 -->

<h1>쿠팡 검색창</h1>

<form action = "https://www.coupang.com/np/search">
<!-- <input type = "hidden" name = "component"> -->
<select name = "component">
<option value = "">전체</option>
<option value = "564553">패션의류/잡화</option>
<option value = "176422">뷰티</option>
<option value = "194176">식품</option>
</select>
<input type = "text" name = "q" placeholder = "상품명을 입력하세요">
<input type = "hidden" name = "channel" value = "user">
<button>검색</button>
</form>