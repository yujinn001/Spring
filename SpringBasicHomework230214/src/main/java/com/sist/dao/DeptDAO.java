package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
public class DeptDAO extends SqlSessionDaoSupport{
	/*
	 * <!-- 1. 목록  -->
	  <select id="deptListData" resultType="DeptVO">
	   select deptno,dname,loc from dept
	  </select>
	  <!-- 2. 내용 출력 -->
	  <select id="deptDetailData" resultType="DeptVO" parameterType="int">
	   select deptno,dname,loc from dept
	   where deptno=#{deptno}
  	  </select>
	 */
	public List<DeptVO> deptListData()
	{                                   // 아이디 명칭
		return getSqlSession().selectList("deptListData");
	}
	public DeptVO deptDetailData(int deptno)
	{                                    // 아이디 명칭      , 매개변수값
		return getSqlSession().selectOne("deptDetailData",deptno);
	}
}
