<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   width:960px;
}
h1{
   text-align: center;
}
</style>
</head>
<body>
  <div class="container">
   <h1>��� �̸�</h1>
   <form method=post action="info.do">
   <div class="row">
    <c:forEach var="name" items="${list }">
     <input type="checkbox" name="names" value="${name }"> ${name }&nbsp;
    </c:forEach>
   </div>
   <div class="row">
    <div class="text-center">
      <input type=submit value="����" class="btn btn-sm btn-danger">
    </div>
   </div>
   </form>
  </div>
</body>
</html>