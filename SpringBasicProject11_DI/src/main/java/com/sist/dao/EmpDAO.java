package com.sist.dao;

import java.util.*;
import com.sist.dao.*;
import org.mybatis.spring.support.SqlSessionDaoSupport; // myBatis���� �������� ������ �� ����ϴ� �κ�

public class EmpDAO extends SqlSessionDaoSupport{

	/*
	 * <select id="empListData" resultType="EmpvO">
		    SELECT empno,ename,job
		    FROM emp
		  </select>
	 */
	public List<EmpVO> empListData()
	{
		return getSqlSession().selectList("empListData");
	}
	public EmpVO empDetailData(int empno)
	{
		return getSqlSession().selectOne("empDetaildData",empno);
	}
}
