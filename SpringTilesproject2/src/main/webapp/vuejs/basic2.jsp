<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		1. V
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top :50px;
}
.row{
	margin:0px auto;
	width:800px;
}
h1{
	text-align:center
}
</style>
</head>
<body>
  <div class="container">
    <h1>Vue 생명 주기</h1>
    <div class="row">
      <input type =text size=30 class="input-sm" v-model="message"> <!-- v-model : Vue 입력한 변수와 입력값이 같다 (기존) id값-->
      <h3>{{message}}</h3>
    </div>
  </div>
<script>
  new Vue({
	 el:'.container',
	 data:{
		 message :'Hello VueJS'
	 },
	 // 생명주기 함수
	 beforeCreate:function(){
		 console.log("beforeCreate Call : 인스턴스 초기화전 : 이벤트 등록..")
		 // componentWillCreate()
	 },
	 created:function(){ // 생성이 끝난 상태
		 console.log("created Call : 인스턴스 생성 완료 : 메모리 할당..")
	     // componentDidCreate()
	 },
	 beforeMount:function(){
		 console.log("beforeMount Call : HTML을 저장할 가상 메모리 확인 : 서버에서 데이터 읽기 = 변수")
	 	// componentWillCreate()
	 },
	 mounted:function(){
		 // componentDidCreate()
		 console.log("mounted Call:  HTML을 저장할 가상 메모리 저장 완료 : 실제돔 비교 => 브라우저에 출력")
	     // 다른 라이브러리 연동 => AJAX, Jquery... => $(function(){})
	 },
	 beforeUpdate:function(){
		 console.log("beforeUpdate Call : 수정 전 상태")
	 },
	 updated:function(){
		 console.log("updated Call : 수정완료 => mounted")
	 },
	 beforeDestory:function(){
		 console.log("beforeDestory Call : 메모리 해제 전 상태")
	 },
	 destoryed:function(){
		 console.log("destoryed Call : 메모리 해제 상태")
	 }
  })
</script>
</body>
</html>