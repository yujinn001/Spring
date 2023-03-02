package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
   JSON / JSONP
   
   JSON => 자바스크립트의 객체 표현법 ==> 모바일 (Kotlin) // 프로그래밍 언어가 다를 때 연결하는 거 : RESTful
   ---------------------------
   {키:값,키:값...} => Object => VO
   [{},{},{}...] => Array => List
*/
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   
   @RequestMapping(value="food/food_search_vue.do", produces="text/plain;charset=UTF-8")
   // JavaScript, HTML, 일반 문자열 => text/html, JSON => text/plain
   public String food_search(String page, String addr)
   {
      if(addr==null) addr="역삼";
      if(page==null) page="1";
      int curpage=Integer.parseInt(page);
      Map map = new HashMap();
      map.put("start", (curpage*20)-19);
      map.put("end", curpage*20);
      map.put("addr", addr);
      List<FoodVO> list = dao.foodSearchData(map);
      int totalpage=dao.foodsearchTotalPage(map);
      // JavaScript에서 인식하는 프로그램으로 변경
      // fno, name, poster
      JSONArray arr = new JSONArray(); // = List
      int i=0;
      for(FoodVO vo:list) {
         JSONObject obj = new JSONObject(); // = VO
         obj.put("fno", vo.getFno());
         obj.put("name", vo.getName());
         String poster = vo.getPoster();
         poster=poster.substring(0,poster.indexOf("^"));
         poster=poster.replace("#", "&");
         obj.put("poster",poster);
         // {fno:1,name:"",poster:""}
         if(i==0) {
            obj.put("curpage", curpage);
            obj.put("totalpage", totalpage);
         }
         arr.add(obj);
         i++;
      }
      System.out.println(arr.toJSONString());
      return arr.toJSONString();
   }
   // Array -> List
   // Object -> VO
   //food/location_detail_vue.do
   @GetMapping(value = "food/location_detail_vue.do" ,produces = "text/plain;charset=utf-8")
   public String food_location_detail(int fno)
   {
	   FoodVO vo=dao.foodLocationDetailData(fno);
	   JSONObject obj=new JSONObject();
	   obj.put("fno", vo.getFno());
	   obj.put("name", vo.getName());
	   obj.put("poster", vo.getPoster());
	   obj.put("tel", vo.getTel());
	   obj.put("address", vo.getAddress());
	   obj.put("parking", vo.getParking());
	   obj.put("time", vo.getTime());
	   obj.put("price", vo.getPrice());
	   obj.put("type", vo.getType());
	   obj.put("menu", vo.getMenu());
	   return obj.toJSONString();
   }
}







































