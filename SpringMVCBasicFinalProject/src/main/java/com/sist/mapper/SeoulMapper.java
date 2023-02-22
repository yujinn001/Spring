package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.vo.*;
public interface SeoulMapper {
	// 목록 (서울)
	//private int no,hit;
	//private String title,poster,msg,address;
	
	@Select("select no,title, poster, address,num "
		  + "from (select no,title, poster, address,rownum as num "
		  + "from (select no,title, poster, address "
		  + "from seoul_location order by no asc )) "
		  + "where num between #{start} and #{end}")
	public List<SeoulVO> seoulLocationListData(Map map);
	
	//목록 페이지네이션 관련
	@Select("select ceil(count(*)/20.0)  from seoul_location")
	public int seoulTotalPage();
	
	// 상세 보기
	@Select("select * from seoul_location where no=#{no}")
	public SeoulVO seoulDetailData(int no);
	
	// 인근 맛집
	@Select("select fno,name,poster,rownum "
		  + "from food_location "
		  + "where rownum<=4 and address like '%'||#{address}||'%'")
	public List<FoodVO> foodLocationData(Map map); 
}
