<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- ajax 관련 스크립트 -->
<!-- <script src='https://cdnjs.cloudflare.com/ajax/libs/vue/1.0.11/vue.js'></script> -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container" id="app">
  <div class="row">
    <input type=text size=20 class="input-sm" v-model="addr"> <!-- v-model : 어떤 변수에 값을 채울것인지 -->
    <input type=button value="검색" class="btn btn-sm btn-primary" @click="search()">
  </div>
  <div style="height:20px"></div>
    <div class="row">
      <div class="col-md-3" v-for="vo in food_list">
		    <div class="thumbnail">
		      <a :href="'../food/location_detail_before.do?fno='+vo.fno"> <!--  : 바인드 (변수값을 줄 때 사용) -->
		        <img :src="vo.poster" title="" style="width:100%">
		        <div class="caption">
		          <p>{{vo.name}}</p>
		        </div>
		      </a>
		    </div>
	  </div>  
	
    </div>
    <div class="row">
	  <div class="text-center">
	   <input type="button" class="btn btn-sm btn-warning" value="이전" @click="prev()">
	    {{curpage}} page/ {{totalpage}} pages
	   <input type="button" class="btn btn-sm btn-info" value="다음" @click="next()">
	  </div>
	</div>  
  </div>
  <%-- 
         Vue 동작 생명주기
         1. created => new Vue()
         2. mounted => onload() =>$(function())
         3. updated => 수정시
         4. destoryed => 종료
         
         역할 then => success (response) 와 같은 역할 // function
         
   --%>
  <script>
   new Vue({
	   el:'#app',
	   data:{   
		   curpage:1,
		   totalpage:0,
		   food_list:[],
		   addr:'역삼'
	   },
	   mounted:function(){
		   	    this.send()
	       },
	       methods:{
	    	 prev:function()
	    	 {
	    		 this.curpage=this.curpage>1?this.curpage-1:this.curpage;
	    		 this.send()
	    	 },
	    	 next:function()
	    	 {
	             this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
	             this.send()

	    	 },
	    	 search:function()
	    	 {
	             this.curpage=1;
	             this.send()

	    	 },
	    	 send:function()
	    	 {
	             let _this=this;// 이부분을 선언 안하면 axios의 this가된다 그래서 선언해서 data의 this로 만든다
	              axios.get("http://localhost:8080/web/food/food_search_vue.do",{
	            	// 기존.then((response) => (변경후).then(function(response) => 변경되면서 this값이 바뀌므로 let _this=this;를 선언한다
	            	  params:{
	                    page:_this.curpage,
	                    addr:_this.addr
	                 }
	              }).then(function(response){
	                 console.log(response.data)
	                 _this.food_list=response.data;
	                 _this.curpage=response.data[0].curpage;
	                 _this.totalpage=response.data[0].totalpage;
	              })
	    	 }
	       }
	    })

  </script>
</body>
</html>













