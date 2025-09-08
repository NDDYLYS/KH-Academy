<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

 <h2>상품권 추가</h2>
 
<form action = "add" method = "post" enctype = "multipart/form-data">
<input type = "text" name = "giftcardName" placeholder = "상품권 이름을 입력하세요." required>
<input type = "text" name = "giftcardContent" placeholder = "상품권 본문을 입력하세요." required>
<input type = "text" name = "giftcardPrice" placeholder = "상품권 가격을 입력하세요." required>
<input type = "text" name = "giftcardPoint" placeholder = "상품권 포인트를 입력하세요." required>
<input type = "file" name = "attach" accept = ".png,.jpg,.webp" required>
<button>상품권 등록</button>
</form>
 
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>