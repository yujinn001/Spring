package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.JeJuLocationVO;

public interface JejuMapper {
	// 목록(여행지)
	@Select("select no,title,poster,price,num "
		  + "from (select no,title,poster,price,rownum as num "
		  + "from (select no,title,poster,price "
		  + "from jejulocation order by no asc)) "
		  + "where num between #{start} and #{end} ")
	public List<JeJuLocationVO> jejuLocationListData(Map map);
	
	@Select("select ceil(count(*)/20.0) from jejulocation ")
	public int jejuTotalPage();
	
}
