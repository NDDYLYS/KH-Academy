<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

 <h2>상품권 추가</h2>
 
<form action = "add" method = "post" enctype = "multipart/form-data">
이름 : <input type = "text" name = "giftcardName" placeholder = "상품권 이름을 입력하세요." required>
내용 : <textarea name = "giftcardContent" placeholder = "상품권 본문을 입력하세요." required
rows = "4" cols = "60"></textarea>
가격 : <input type = "text" name = "giftcardPrice" placeholder = "상품권 가격을 입력하세요." required inputmode = "numeric">
포인트 : <input type = "text" name = "giftcardPoint" placeholder = "상품권 포인트를 입력하세요." required inputmode = "numeric">
<input type = "file" name = "attach" accept = "image/*" required>
<button>상품권 등록</button>
</form>

<!-- error 파라미터가 있다면 오류 메세지 출력 -->
<c:if test = "${ param.error != null }">
	<h2 style = "color:red">이미지는 반드시 설정해야 합니다.</h2>
</c:if>
 
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>