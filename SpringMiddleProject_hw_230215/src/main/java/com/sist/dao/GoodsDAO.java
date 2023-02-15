package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsCategoryMapper;
import com.sist.mapper.GoodsMapper;
import com.sist.vo.GoodsCategoryVO;
import com.sist.vo.GoodsVO;

@Repository // 메모리 할당
// dao는  mapper를 가져다 사용한다
public class GoodsDAO {
	@Autowired
	private GoodsMapper gmapper;
	@Autowired
	private GoodsCategoryMapper cmapper;
	public List<GoodsCategoryVO> categoryListData()
	{
		return cmapper.categoryListData();
	}
	
	public List<GoodsVO> goodsListData(Map map)
	{
		return gmapper.goodsListData(map);
	}

}
