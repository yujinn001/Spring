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
   
   @Update("UPDATE project_food SET "
		  +"hit=hit+1 "
		  +"WHERE fno=#{fno}")
   public void foodHitIncrement(int fno);
   
   @Select("SELECT * FROM project_food "
		  +"WHERE fno=#{fno}")
   public FoodVO foodDetailData(int fno);
   
   // 검색 
   @Select("SELECT fno,name,poster,score,num "
		  +"FROM (SELECT fno,name,poster,score,rownum as num "
		  +"FROM (SELECT fno,name,poster,score "
		  +"FROM food_location "
		  +"WHERE address LIKE '%'||#{address}||'%' ORDER BY fno ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<FoodVO> foodLocationFindData(Map map);
   
   // 총페이지 구하기 
   @Select("SELECT CEIL(COUNT(*)/20.0) "
		  +"FROM food_location "
		  +"WHERE address LIKE '%'||#{address}||'%'")
   public int foodFindTotalPage(String address);
   // 상세보기 
   @Select("SELECT * FROM food_location "
		  +"WHERE fno=#{fno}")
   public FoodVO foodLocationDetailData(int fno);
   
   // 인기맛집 7
   @Select("SELECT fno,name,address,score,rownum "
		  +"FROM (SELECT fno,name,address,score "
		  +"FROM project_food ORDER BY hit DESC) "
		  +"WHERE rownum<=7")
   public List<FoodVO> foodTop7();
   
   // 맛집명을 가지고 온다 (추천)
   @Select("SELECT DISTINCT name FROM food_location "
		  +"WHERE length(name)>1 AND name!='라구'")
   public List<String> foodGetNameData();
   
   // 맛집 정보 읽기 
   @Select("SELECT fno,name,poster,score,rownum "
		  +"FROM (SELECT fno,name,poster,score "
		  +"FROM food_location ORDER BY fno ASC) "
		  +"WHERE name=#{name} AND rownum=1")
   public FoodVO foodInfoData(String name);
   
}







