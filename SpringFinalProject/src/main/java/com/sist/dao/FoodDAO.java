package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Update;
=======
>>>>>>> 8f26dca6d86dd67c191bcdeb5e01ce0cc138fe35
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
<<<<<<< HEAD
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
=======
>>>>>>> 8f26dca6d86dd67c191bcdeb5e01ce0cc138fe35
}