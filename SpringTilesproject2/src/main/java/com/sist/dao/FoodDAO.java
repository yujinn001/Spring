package com.sist.dao;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	//@Select("select cno,title,poster,subject from project_category")
	public List<CategoryVO> categoryListData()
	{
		return mapper.categoryListData();
	}
	
	//@Select("select fno,cno,name,tel,address,type,poster "
	//  + "from project_food "
    // + "where cno=#{cno}")
	public List<FoodVO> foodListData(int cno)
	{
		return mapper.foodListData(cno);
	}
	
    //@Select("select title,subject from project_category "
	//  + "where cno=#{cno}")
	public CategoryVO categoryInfoData(int cno)
	{
		return mapper.categoryInfoData(cno);
	}
	
	//@Select("select * from project_food "
	//  + "where fno=#{fno}")
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	
	//	@Select("select fno,name,poster,num "
	//  + "from (select fno,name,poster,rownum as num "
	//  + "from (select fno,name,poster "
	//  + "from food_location where address like '%'||#{addr}||'%' order by fno asc)) "
	//  + "where num between #{start} and #{end}")
	public List<FoodVO> foodSearchData(Map map)
	{
		return mapper.foodSearchData(map);
	}
	
	//@Select("select ceil(count(*)/20.0) from food_location "
	//  + "where address like '%'||#{addr}||'%' ")
	public int foodsearchTotalPage(Map map)
	{
		return mapper.foodSearchTotalPage(map);
	}
	
	// @Select("select * from food_location "
	//	 + "where fno=#{fno}")
	public FoodVO foodLocationDetailData(int fno)
	{
		return mapper.foodLocationDetailData(fno);
	}
	//@Select({
    /*"<script>"
	  + "select cno,title,poster "
	  + "from project_category "
	  + "where "
	  + "<if test='no==1'>"
	  + "cno between 1 and 12"
	  + "</if>"
	  + "<if test='no==2'>"
	  + "cno between 13 and 18"
	  + "</if>"
	  + "<if test='no==3'>"
	  + "cno between 19 and 30"
	  + "</if>"
	  + "</script>"
	  })*/
	public List<CategoryVO> categoryVueData(Map map)
	{
		return mapper.categoryVueData(map);
	}

}
































