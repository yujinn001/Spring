package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.SeoulVO;

// XML없이 사용하는 방법
public interface SeoulMapper {
	//<select>
	@Select("SELECT no,title,msg,address FROM ${seoul_tbl}")
	public List<SeoulVO> seoulListData(Map map);
	
	@Select("SELECT no,title,msg,address FROM ${seoul_tbl} "
			+ "where no=#{no}")
	public SeoulVO seoulDetailData(Map map);
}
