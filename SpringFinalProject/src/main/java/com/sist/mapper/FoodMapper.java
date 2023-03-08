package com.sist.mapper;
import java.util.*; 

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface FoodMapper {
   @Select("SELECT cno,title,poster "
		  +"FROM project_category ORDER BY cno ASC")
   public List<CategoryVO> categoryListData();
   
   @Select("SELECT title,subject FROM project_category "
		  +"WHERE cno=#{cno}")
   public CategoryVO categoyInfoData(int cno);
   
   @Select("SELECT fno,name,poster,score,tel,address,type "
		  +"FROM project_food "
		  +"WHERE cno=#{cno}")
   public List<FoodVO> foodListData(int cno);

   
   @Update("update project_food set "
   		 + "hit = hit+1 "
   		 + "where fno=#{fno}")
   public void foodHitIncrement(int fno);
   // 상세보기
   @Select("select * from project_food "
   		 + "where fno=#{fno}")
   public FoodVO foodDetailData(int fno);
   
   // 검색 (반복 속성이 많을 경우 VueJS로 출력)
   @Select("SELECT fno,name,poster,score,num "
	         +"FROM (SELECT fno,name,poster,score,rownum as num "
	         +"FROM (SELECT fno,name,poster,score "
	         +"FROM food_location "
	         +"WHERE address LIKE '%'||#{address}||'%' ORDER BY fno ASC)) "
	         +"WHERE num BETWEEN #{start} AND #{end} ")
   public List<FoodVO> foodLocationFindData(Map map);
   
   // 상세보기
   @Select("select * from food_location "
   	 	 + "where fno=#{fno}")
   public FoodVO foodLocationDetailData(int fno);
   
   // 총페이지
   @Select("select ceil(count(*)/20.0) "
         + "from food_location "
         + "where address LIKE '%'||#{address}||'%' ")
   public int foodFindTotalPage(String address);
   
   // 인기 맛집 7개 출력
   @Select("select fno,name,address,score,rownum "
   		 + "from (select fno,name,address,score "
   		 + "from project_food order by hit desc )"
   		 + "where rownum <=7")
   public List<FoodVO> foodTop7();
   
}

























