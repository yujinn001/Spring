package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;

@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	/* @Select("select title,chef,poster,rownum "
		  + "from recipe "
		  + "where rownum<=40 and regexp_like(title,#{meny}") */
	public List<RecipeVO> recipeFindData(String menu)
	{
		return mapper.recipeFindData(menu);
	}
}
