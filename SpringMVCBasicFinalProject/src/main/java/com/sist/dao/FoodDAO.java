package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<CategoryVO> categoryListData(Map map)
	{
		return mapper.categoryListData(map);
	}
	/*
	 * 	// 카테고리별 목록 출력
		@Select("SELECT fno,name,poster,address,tel,type,score "
				+"FROM project_food "
				+"WHERE cno=#{cno}")*/
	public List<FoodVO> foodListData(int cno)
	{
		return mapper.foodListData(cno);
	}
		
	/*	@Select("SELECT title,subject FROM project_category "
				+"WHERE cno=#{cno}")*/
	public CategoryVO categoryInfoData(int cno)
	{
		return mapper.categoryInfoData(cno);
	}
		
		// 상세보기
	/*	@Select("select * from project_category "
			  + "where fno=#{fno}")*/
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	//  @Select({
	//  "<script>"
	//  + "select fno, name, poster, num "
	//  + "from (select fno, name, poster, rownum as num "
	//  + "from (select fno, name, poster "
	//  + "from food_location "
	//  + "<if test=\"ss!='all'\">"
	//  + "where address like '%'||#{ss}||'%'"
	//  +"</if>"
	//  + "order by fno asc)) "
	//  + "where num between #{start} and #{end}"
	//  + "</script>"
	//  
	//})
	public List<FoodVO> foodFindData(Map map){
	  return mapper.foodFindData(map);
	}

	 
	 
}
