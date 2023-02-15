package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.DeptVO;

public interface DeptMapper {
	// 자동 구현
	@Select("select deptno,dname,loc from dept")
	public List<DeptVO> deptListData(); //getconnection,disconnection이 포함되어있다
	
}
