package com.sist.dao;
import java.util.*; 

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class FoodDAO {
  @Autowired
  private FoodMapper mapper;
  
  /*@Select("SELECT cno,title,poster "
		  +"FROM project_category")*/
  public List<CategoryVO> categoryListData()
  {
	  return mapper.categoryListData();  
  }
  
  /*@Select("SELECT title,subject FROM project_category "
		  +"WHERE cno=#{cno}")*/
  public CategoryVO categoyInfoData(int cno)
  {
	  return mapper.categoyInfoData(cno);
  }
  
  /*@Select("SELECT fno,name,poster,score,tel,address,type "
		  +"FROM project_food "
		  +"WHERE cno=#{cno}")*/
  public List<FoodVO> foodListData(int cno)
  {
	  return mapper.foodListData(cno);
  }

  /*@Update("update project_food set "
   		 + "hit = hit+1 "
   		 + "where fno=#{fno}")
   public void foodHitIncrement(int fno);
   // 상세보기
   @Select("select * from project_food "
   		 + "where fno=#{fno}")*/
   public FoodVO foodDetailData(int fno)
   {
	   mapper.foodHitIncrement(fno);
	   return mapper.foodDetailData(fno);
   }
   public FoodVO foodCookieDetailData(int fno)
   {
	   return mapper.foodDetailData(fno);
   }
   // 검색 (반복 속성이 많을 경우 VueJS로 출력)
   //@Select("select fno,name,poster,score,num "
   //		 + "from (select fno,name,poster,score,rownum as num "
   //		 + "from (select fno,name,poster,score "
   //		 + "from food_location "
   //		 + "where address LIKE '%'||#{address}||'%' order by fno asc "
   //		 + "where num between #{start} and #{end}")
   public List<FoodVO> foodLocationFindData(Map map)
   {
	   return mapper.foodLocationFindData(map);
   }
   
   // 상세보기
   //@Select("select * from food_location "
   //	 	 + "where fno=#{fno}")
   public FoodVO foodLocationDetailData(int fno)
   {
	   return mapper.foodLocationDetailData(fno);
   }
   // // 총페이지
   //@Select("select ceil(count(*)/20.0) "
   //         + "from food_location "
   //         + "where address like '%'||#{address}||'%'")
   public int foodFindTotalPage(String address)
   {
	   return mapper.foodFindTotalPage(address);
   }
   // (Top-N => 인라인뷰 이용) 인기 맛집 7개 출력
   //@Select("select fno,name,address,rownum "
   //		 + "from (select fno,name,address "
   //		 + "from project_food order by hit desc )"
   //		 + "where rownum <=7")
   public List<FoodVO> foodTop7()
   {
	   return mapper.foodTop7();
   }
}
















