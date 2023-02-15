package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

// 인터페이스는 메모리 할당을 하지 않는다
public interface SeoulMapper {
	@Select("select no,title,address from ${seoul_tbl}")
	public List<SeoulVO> seoulListData(Map map); // String이 아니라 Map => Map의 key이름
}
