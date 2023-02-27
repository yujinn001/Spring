<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
   
}
.row{
   margin: 0px auto;
   width: 1200px;
}

h1{
   text-align: center;
}
</style>
</head>
<body>
   <div class="container">
     <h1>맛집</h1>
     <div style="height: 20px"></div>
      <div class="row">
        <form method="post" action="../food/find.do"> <!-- post방식 -->
          <input type="checkbox" naeme="types" value="N">맛집명 &nbsp;
          <input type="checkbox" naeme="types" value="A">주소 &nbsp;
          <input type="checkbox" naeme="types" value="T">음식 종류 &nbsp;
          <input type="text" name="ss" class="input-sm" size="20">
          <input type="submit" value="검색" class="btn btn-sm btn-danger">
        </form>
      </div>
      <div style="height: 30px"></div>
      <div class="row">
        <c:forEach var="vo" items="${list}">
         <div class="col-md-3">
             <div class="thumbnail">
               <a href="#">
                 <img src="${vo.poster }" style="width:100%">
                 <div class="caption">
                   <p>${vo.name }</p>
                 </div>
               </a>
             </div>
           </div>
          </c:forEach>
      </div>
      <div class="row">
         <div class="text-center">
            <ul class="pagination">
               <c:if test="${startPage>1 }"><%--startPage : 1, 6, 11, 16.. --%>
                  <li><a href="../food/list.do?page=${startPage-1 }">&lt;</a></li>
               </c:if>
               <c:forEach var="i" begin="${startPage }" end="${endPage }">
                  <li ${curpage==i?"class=active":"" }><a href="../food/list.do?page=${i }">${i }</a></li>
               </c:forEach>
               <c:if test="${endPage<totalpage }">
                 <li><a href="../food/list.do?page=${endPage+1 }">&gt;</a></li>
                </c:if>
            </ul>
         </div>
      </div>
   </div>
</body>
</html>