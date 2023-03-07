package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Update;
=======
>>>>>>> 8f26dca6d86dd67c191bcdeb5e01ce0cc138fe35

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
<<<<<<< HEAD
   
   @Update("update project_food set "
   		 + "hit = hit+1 "
   		 + "where fno=#{fno}")
   public void foodHitIncrement(int fno);
   // 상세보기
   @Select("select * from project_food "
   		 + "where fno=#{fno}")
   public FoodVO foodDetailData(int fno);
=======
>>>>>>> 8f26dca6d86dd67c191bcdeb5e01ce0cc138fe35
}