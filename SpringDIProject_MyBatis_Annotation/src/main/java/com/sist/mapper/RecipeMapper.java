package com.sist.mapper;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
import java.util.*;
public interface RecipeMapper {
	@Select(" select no,title,chef,rownum "
			+ "	  from (select no,title,chef from recipe order by no asc) "
			+ "	  where rownum<=30")
	public List<RecipeVO> recipeListData();
}
