package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsVO;

// 인터페이스는 메모리 할당을 하지 않는다

public interface GoodsMapper {
	//rownum 추가하기
	@Select("select no,goods_name,goods_price from ${goods_tbl} where rownum<=30")
	public List<GoodsVO> goodsListData(Map map);
}
