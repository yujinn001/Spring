package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;
import com.sist.vo.FoodVO;
import com.sist.vo.SeoulVO;

@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	
	/*@Select("select no,title, poster, address,num "
		  + "from (select no,title, poster, address,rownum as num "
		  + "from (select no,title, poster, address "
		  + "from seoul_location order by no asc )) "
		  + "where num between #{start} and #{end}")*/
	public List<SeoulVO> seoulLocationListData(Map map)
	{
		return mapper.seoulLocationListData(map);
	}
	//@Select("select ceil(count(*)/20.0)  from seoul_location")
	public int seoulTotalPage()
	{
		return mapper.seoulTotalPage();
	}
	//@Select("select * from seoul_location where no=#{no}")
	public SeoulVO seoulDetailData(int no)
	{
		return mapper.seoulDetailData(no);
	}
	// 인근 맛집
	//@Select("select fno,name,poster,rownum "
	//		  + "from food_location "
	//		  + "where rownum<=4 and address like '%'||#{address}||'%'")
	public List<FoodVO> foodLocationData(Map map)
	{
		return mapper.foodLocationData(map);
	}
}















