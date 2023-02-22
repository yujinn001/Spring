<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top:50px;
}
.row{
  margin:0px auto;
  width:800px;
}
h1{
  text-align:center;
}
p {
  overflow: hidden;  		
  text-overflow: ellipsis;  	
  white-space: nowrap; 		
  word-break:break-all
  width: 100px;
  height: 20px;
}
</style>
</head>
<body>
<div class="container">
	<h1>서울 명소</h1>
	<div style="height:10px"></div>
	<div class="row">
	 <c:forEach var="vo" items="${list }">
	   <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="../seoul/detail.do?no=${vo.no }">
		        <img src="${vo.poster }" alt="Lights" style="width:280px;height:180px">
		        <div class="caption">
		          <p >${vo.title }</p>
		        </div>
		      </a>
		    </div>
  		</div>
	  </c:forEach>
	 </div>
	 <div style="height:10px"></div>
	 < <div class="row text-center">
	  <div>
		<ul class="pagination">
		 <c:if test="${startPage>1 }">
		  <li><a href="../seoul/list.do?page=${startPage-1 }">&lt;</a></li>
		 </c:if>
		  <c:forEach var="i" begin="${startPage }" end="${endPage }">
		    <li ${curpage==i?"class=active":""}><a href="../seoul/list.do?page=${i }">${i }</a></li>
		  </c:forEach>
		 <c:if test="${endPage<totalpage }">
		  <li><a href="../seoul/list.do?page=${endPage+1 }">&gt;</a></li>
		 </c:if>
		</ul>
	  </div>
	 </div> 
	</div>
 </div>
</body>
</html>







