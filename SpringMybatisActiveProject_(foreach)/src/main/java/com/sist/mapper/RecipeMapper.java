package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
// 간단한 sql은 @select문장을 사용한다

import com.sist.dao.RecipeVO;
public interface RecipeMapper {
	@Select("select title,chef,poster,rownum "
		  + "from recipe "
		  + "where rownum<=40 and regexp_like(title,#{meny})") //regexp_like를 사용하면 foreach문이 필요없다
	                                						 //regexp를 사용하면 OR가 붙어서 나온다?? 
	public List<RecipeVO> recipeFindData(String menu);
}
