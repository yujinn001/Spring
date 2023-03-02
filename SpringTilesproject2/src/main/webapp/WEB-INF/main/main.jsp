<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row{
  margin: 0 auto;
  width: 1200px;
}
</style>
</head>
<body>
  <%-- include하는 부분 --%>
  <%-- <jsp:include page="header.jsp"> --%>
  <tiles:insertAttribute name="header"/>
  <tiles:insertAttribute name="home"/>
  <tiles:insertAttribute name="footer"/> 
</body>
</html>