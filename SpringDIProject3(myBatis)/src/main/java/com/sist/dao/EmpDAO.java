package com.sist.dao;
import java.util.*;

// SqlSessionDaoSupport : 동작하는 부분 (값을 넣어줘야 한다)
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sist.vo.*;

public class EmpDAO extends SqlSessionDaoSupport {	
	public List<EmpVO> empListData()
	{	// selectList에서 리턴형이 EmpVo로 바뀐다 (제네릭스)
		// resultType의 변수명을 보고 리턴형을 확인한다
		// 자동으로 변경이 돼서 형변환을 시키지 않는다 그래서 selectList로 자동으로 변경된다!!
		return getSqlSession().selectList("empListData");// empListData :id 값
	}
}
