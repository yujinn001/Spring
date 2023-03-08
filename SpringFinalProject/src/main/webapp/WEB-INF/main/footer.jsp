<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row4">
  <footer id="footer" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="one_third first">
      <h6 class="title">오늘의 뉴스</h6>
       <article>
        <c:forEach var="vo" items="${nList }" varStatus="s">
         <c:if test="${s.index<7 }">
           <p>${s.index+1 }.&nbsp;<a href="${vo.link }" target="_blank">${vo.title }</a>(${vo.pubDate })</p>
         </c:if>
        </c:forEach>
        </article>
        <article>
         <p><a href="../news/find.do">더보기</a></p>
        </article>
      <ul class="nospace">
        <li class="btmspace-10"><span class="fa fa-phone"></span> +00 (123) 456 7890</li>
        <li><span class="fa fa-envelope-o"></span> info@domain.com</li>
      </ul>
    </div>
    
    <div class="one_third">
      <h6 class="title">인기레시피</h6>
      <article>
        <h2 class="nospace"><a href="#">Lorem ipsum dolor</a></h2>
        <time class="smallfont" datetime="2045-04-06">Friday, 6<sup>th</sup> April 2045</time>
        <p>Vestibulumaccumsan egestibulum eu justo convallis augue estas aenean elit intesque sed.</p>
      </article>
    </div>
    <div class="one_third">
      <h6 class="title">인기맛집</h6>
      <article>
        <c:forEach var="vo" items="${tList }">
         <p><a href="../food/food_detail.do?fno=${vo.fno }">${vo.name }</a>&nbsp; <span style="color: orange">${vo.score }</span>&nbsp;(${vo.address })</p>
        </c:forEach>
        </article>
    </div>
    </footer>
</div>
<div class="wrapper row5">
  <div id="copyright" class="clear"> 
    <p class="fl_left">Copyright &copy; 2023 - 강남 쌍용 교육센터 - <a href="#">3강의장</a></p>
    <p class="fl_right">제작 <a target="_blank" href="https://www.os-templates.com/" title="Free Website Templates">3강의장</a></p>
  </div>
</div>
</body>
</html>