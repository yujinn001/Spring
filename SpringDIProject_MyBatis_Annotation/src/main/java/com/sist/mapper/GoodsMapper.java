package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsVO;

public interface GoodsMapper {
	@Select("	select no,name,price,rownum "
			+ "		from (select no,goods_name as name,goods_price as price from goods_all order by no asc) "
			+ "		where rownum<=30")
	public List<GoodsVO> goodsListData();
}
