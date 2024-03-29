<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <div id="logo" class="fl_left">
      <h1><a href="../main/main.do">Recipe & Food</a></h1>
    </div>
    <div class="fl_right">
     <c:if test="${sessionScope.id==null }">
      <ul class="inline">
        <li>ID:<input type=text name="id" size=15 class="input-sm"  ref="id" value="${id }"></li>
        <li>PW:<input type=password name=pwd class="input-sm" v-model="pwd" ref="pwd"></li>
        <c:if test="${ck==true }">
         <li>ID 저장:<input type="checkbox" ref="ck"  checked></li>
        </c:if>
        <c:if test="${ck==false }">
         <li>ID 저장:<input type="checkbox" ref="ck"></li>
        </c:if>
        <li><input type=button value="로그인" class="btn btn-sm btn-danger" v-on:click="login()"></li>
      </ul>
     </c:if>
     <c:if test="${sessionScope.id!=null }">
      <ul class="inline">
        <li>${sessionScope.name }님(${sessionScope.admin=='y'?'관리자':'일반 사용자' }) 로그인 중입니다</li>
        <li><input type=button value="로그아웃" class="btn btn-sm btn-success" v-on:click="logout()"></li>
      </ul>
     </c:if>
    </div>
    
  </header>
</div>
<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
    <ul class="clear">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <li><a class="drop" href="#">회원</a>
        <ul>
          <li><a href="../member/join.do">회원가입</a></li>
          <li><a href="../pages/full-width.html">아이디찾기</a></li>
          <li><a href="../pages/sidebar-left.html">비밀번호찾기</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="../food/food_find.do">지역별 찾기</a></li>
          <li><a href="../food/recommand.do">맛집 추천</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">제주</a>
        <ul>
          <li><a href="../jeju/location.do">행사&관광</a></li>
          <li><a href="../jeju/food.do">제주맛집</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">스토어</a>
        <ul>
          <li><a href="../food/food_find.do">전체</a></li>
          <li><a href="../food/food_recommand.do">특가</a></li>
          <li><a href="../food/food_recommand.do">베스트</a></li>
          <li><a href="../food/food_recommand.do">신상</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">레시피</a>
        <ul>
          <li><a href="../recipe/recipe_list.do">레시피</a></li>
          <li><a href="../recipe/chef_list.do">쉐프</a></li>
          <li><a href="../pages/sidebar-left.html">가격비교</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="../board/list.do">게시판</a></li>
          <li><a href="../pages/full-width.html">공지사항</a></li>
        </ul>
      </li>
      <c:if test="${sessionScope.id!=null }">
       <li><a href="../chat/chat.do">채팅</a></li>
      </c:if>
      <li><a href="#">마이페이지</a></li>
    </ul>
  </nav>
</div>
<script>
  new Vue({
	  el:'#header',
	  data:{
		  id:'',
		  pwd:'',
		  msg:'',
		  ck:false
	  },
	  methods:{
		  login:function(){
			  //alert("ck="+this.ck)
			  this.id=this.$refs.id.value; // v-model을 쿠키저장하려고 뺌 그래서 이렇게 선언함
			  this.ck=this.$refs.ck.checked;
			  if(this.id.trim()=="")
			  {
				  this.$refs.id.focus();
				  return
			  }
			  if(this.pwd.trim()=="")
			  {
				  this.$refs.pwd.focus();
				  return
			  }
			  
			  let _this=this
			  axios.get('http://localhost:8080/web/member/login_vue.do',{
				  params:{
					  id:this.id,
					  pwd:this.pwd,
					  ck:this.ck
				  }
			  }).then(function(response){
				  let res=response.data.trim();
				  if(res==='NOID')
				  {
					  
					  alert("아이디가 존재하지 않습니다!!")
					  _this.id='';
					  _this.pwd='';
					  _this.$refs.id.focus();
				  }
				  else if(res==='NOPWD')
				  {
					  alert("비밀번호가 틀립니다!!")
					  _this.pwd='';
					  _this.$refs.pwd.focus();
				  }
				  else
				  {
					  location.href="../main/main.do"
				  }
			  })
		  },
		  logout:function(){
			  axios.get('http://localhost:8080/web/member/logout_vue.do').then(function(response){
				  location.href="../main/main.do";
			  })
		  }
	  }
  })
</script>
</body>
</html>