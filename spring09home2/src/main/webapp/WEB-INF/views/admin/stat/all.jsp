<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script type="text/javascript">
$(function (){
  function createChart(url,selector,chartType){
    $.ajax({
      url:url,
      method:"post",
      success:function(response){ // List<StatVO>
        var labels=[],data=[];
        for(var i=0;i<response.length;i++){
          labels[i]=response[i].title;
          data[i]=response[i].value;
        }
        new Chart($(selector)[0],{
          type:chartType,
          data:{labels:labels,datasets:[{label:"",data:data,borderWidth:1,},]},
          options:{scales:{y:{beginAtZero:true}}}
        });
      }
    });
  }

  createChart("/rest/admin/stat/pokemon", ".pokemon-chart", "polarArea");
  createChart("/rest/admin/stat/student", ".student-chart", "bar");
  createChart("/rest/admin/stat/book", ".book-chart", "line");
  createChart("/rest/admin/stat/member", ".member-chart", "doughnut");
});
</script>


<div class="container w-800">
    <div class="cell center">
        <h1>홈페이지 통계</h1>
    </div>

    <div class="cell">
        <div class="flex-box">
            <div class="w-100 center">
                <div class="flex-box flex-center">
                    <label>포켓몬</label>
                    <a href="http://www.localhost:8080/admin/stat/pokemon">(더보기)</a>
                </div>
                <canvas class="pokemon-chart"></canvas>
            </div>

            <div class="w-100 center">
                <div class="flex-box flex-center">
                    <label>학생</label>
                    <a href="http://www.localhost:8080/admin/stat/student">(더보기)</a>
                </div>
                <canvas class="student-chart"></canvas>
            </div>
        </div>
    </div>

    <div class="cell">
        <div class="flex-box">
            <div class="w-100 center">
                <div class="flex-box flex-center">
                    <label>도서</label>
                    <a href="http://www.localhost:8080/admin/stat/book">(더보기)</a>
                </div>
                <canvas class="book-chart"></canvas>
            </div>

            <div class="w-100 center">
                <div class="flex-box flex-center">
                    <label>회원</label>
                    <a href="http://www.localhost:8080/admin/stat/member">(더보기)</a>
                </div>
                <canvas class="member-chart"></canvas>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>