package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.vo.*;
public class RecipeDAO extends SqlSessionDaoSupport{
	public List<RecipeVO> recipeListData()
	{
		return getSqlSession().selectList("recipeListData");
		// resultType="RecipeVO"
		// List<RecipeVO> =>selectList
		// RecipeVO => selectOne
	}
	
}
