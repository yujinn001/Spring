package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.FoodVO;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
		  + "from (SELECT fno,name,poster,rownum as num "
		  + "from (SELECT fno,name,poster "
		  + "from food_location order by fno asc)) "
		  + "where num between #{start} and #{end} ")
	public List<FoodVO> foodListData(Map map);
	
	@Select("select ceil(count(*)/20.0) from food_location")
	public int foodTotalPage();
	
	//<select id="foodFindData" resultType="FoodVO" parameterType="hashmap">
	public List<FoodVO> foodFindData(Map map);
	
	//<select id="foodFindCount" resultType="int" parameterType="hashmap">
	public int foodFindCount(Map map);  
}
