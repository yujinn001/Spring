package com.sist.dao;
import java.util.*;

import javax.websocket.server.ServerEndpoint;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.mapper.*;
import com.sist.vo.*;

@Service
public class RecipeService {
	@Autowired
	private RecipeMapper rMapper;
	
	@Autowired
	private ChefMapper cMapper;
	
	// Recipe 관련
	//@Select("select no,title,poster,chef,num "
	//		  + "from (select no,title,poster,chef,rownum as num "
	//		  + "from (select /*+ index_asc(recipe receipe_no_pk)*/no,title,poster,chef "
	//		  + "from recipe)) "
	//		  + "where num between #{start} and #{end}")
	public List<RecipeVO> recipeListData(Map map)
	{
		return rMapper.recipeListData(map);
	}
		
	//@Select("select ceil(count(*)/20.0) from recipe")
	public int recipeTotalPage()
	{
		return rMapper.recipeTotalPage();
	}
		
	//@Select("select count(*) from recipe")
	public String recipeRowCount()
	{
		return rMapper.recipeRowCount();
	}
	
	// Chef 관련
	//@Select("select chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2,num "
	//		  + "from (select chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2,rownum as num "
	//		  + "from (select chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2 "
	//		  + "from chef)) "
	//		  + "where num between #{start} and #{end}")
	public List<ChefVO> chefListData(Map map)
	{
		return cMapper.chefListData(map);
	}
		
	//@Select("select ceil(count(*)/50.0) from chef")
	public int chefTotalPage()
	{
		return cMapper.chefTotalPage();
	}
	
	// 쉐프의 작품
	//@Select("select no,title,poster,chef,rownum "
	//  + "from recipe "
	//  + "where chef=#{chef} and rownum <=20")
	public List<RecipeVO> chefMakeRecipeData(String chef)
	{
		return cMapper.chefMakeRecipeData(chef);
	}
	
}
