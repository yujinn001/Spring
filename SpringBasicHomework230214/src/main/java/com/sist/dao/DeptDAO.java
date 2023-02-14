package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
public class DeptDAO extends SqlSessionDaoSupport{
	/*
	 * <!-- 1. ���  -->
	  <select id="deptListData" resultType="DeptVO">
	   select deptno,dname,loc from dept
	  </select>
	  <!-- 2. ���� ��� -->
	  <select id="deptDetailData" resultType="DeptVO" parameterType="int">
	   select deptno,dname,loc from dept
	   where deptno=#{deptno}
  	  </select>
	 */
	public List<DeptVO> deptListData()
	{                                   // ���̵� ��Ī
		return getSqlSession().selectList("deptListData");
	}
	public DeptVO deptDetailData(int deptno)
	{                                    // ���̵� ��Ī      , �Ű�������
		return getSqlSession().selectOne("deptDetailData",deptno);
	}
}
