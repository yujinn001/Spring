package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;


import com.sist.vo.*;
public interface FoodMapper {
	@Select({
		"<script>"
		+"select cno,title,poster,subject "
	    +"from project_category "
	    +"where "
	    +"<if test='cno==1'>"
	    +"cno between 91 and 122"
	    +"</if>"  // 동적 쿼리 => 자바에서 코딩하ㄱ지 않고 이렇게 한다
	    +"<if test='cno==2'>"
	    +"cno between 123 and 138"
	    +"</if>"  
	    +"<if test='cno==3'>"
	    +"cno between 139 and 150"
	    +"</if>" 
	    +"</script>"
	})
	public List<CategoryVO> categoryListData(Map map);
	// 카테고리별 목록 출력
	@Select("SELECT fno,name,poster,address,tel,type,score "
			+"FROM project_food "
			+"WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
	
	@Select("SELECT title,subject FROM project_category "
			+"WHERE cno=#{cno}")
	public CategoryVO categoryInfoData(int cno);
	
	// 상세보기
	@Select("select * from project_food "
		  + "where fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	// 검색 : 동적 쿼리 (<if>,<choose>,<foreach>:IN ,<trim>,<set>)
	// ({ => 스크립트 사용
	@Select({
		"<script>"
		+"select fno,name,poster,num "
		+"from (select fno,name,poster,rownum as num "
		+"from (select fno,name,poster "
		+"from food_location "
		+"<if test=\"ss!='all'\"> "
		+"where address LIKE '%'||#{ss}||'%' "
		+"</if> "
		+"order by fno asc)) "
		+"where num between #{start} and #{end} "
		+"</script>"
	})
	public List<FoodVO> foodFindData(Map map); 
}












