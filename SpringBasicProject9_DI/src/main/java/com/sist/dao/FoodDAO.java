package com.sist.dao;

import java.util.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;

                         //SqlSessionDaoSupport 정보를 받아온다
public class FoodDAO extends SqlSessionDaoSupport{
	/*   <select id="foodListData" resultType="FoodVO">
		    SELECT fno,name,address,rownum
		    FROM food_location
		    WHERE rownum&lt;=50
		  </select>
	 */
	public List<FoodVO> foodListData()
	{
		return getSqlSession().selectList("foodListData"); //List로 묶을 때는 selectList
		/*
		 *  while(rs.next())
		 *  {
		 *     FoodVO vo =new FoodVO();
		 *     vo.setFno(rs.getInt("fno")
		 *     ...
		 *     ...
		 *     list.add(vo);
		 *  }
		 */
	}
	/*  <select id="foodDetailData" resultType="FoodVO" parameterType="int"> <!-- ?에 대한 값이 정수다(int) -->
		    SELECT fno,name,address,rownum
		    FROM food_location
		    WHERE fno=#{fno}
		  </select>
	 */
	public FoodVO foodDetailData(int fno)
	{
		return getSqlSession().selectOne("foodDetailData",fno);
		/* FoodVO vo =new FoodVO();
		 * vo.setFno(rs.getInt("fno")
		 * ..
		 * ..
		 */
	}
}
