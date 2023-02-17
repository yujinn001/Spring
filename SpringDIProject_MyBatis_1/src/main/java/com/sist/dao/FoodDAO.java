package com.sist.dao;
// 이부분은 xml로 받았을 때 사용한다
import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.vo.*;
public class FoodDAO extends SqlSessionDaoSupport{
	public List<FoodVO> foodListData()
	{
		return getSqlSession().selectList("foodListData");
	}
}
