package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
// ������ sql�� @select������ ����Ѵ�

import com.sist.dao.RecipeVO;
public interface RecipeMapper {
	@Select("select title,chef,poster,rownum "
		  + "from recipe "
		  + "where rownum<=40 and regexp_like(title,#{meny})") //regexp_like�� ����ϸ� foreach���� �ʿ����
	                                						 //regexp�� ����ϸ� OR�� �پ ���´�?? 
	public List<RecipeVO> recipeFindData(String menu);
}
