package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.vo.*;
public class GoodsDAO extends SqlSessionDaoSupport{
	public List<GoodsVO> goodsListData()
	{
		 return getSqlSession().selectList("goodsListData"); 
	}
}