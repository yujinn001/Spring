package com.sist.dao;

import java.util.*;
import com.sist.dao.*;
import org.mybatis.spring.support.SqlSessionDaoSupport; // myBatis에서 스프링을 연결할 떄 사용하는 부분

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
