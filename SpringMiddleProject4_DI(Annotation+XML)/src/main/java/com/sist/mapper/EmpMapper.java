package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;

import jdk.internal.module.ModuleLoaderMap.Mapper;
public interface EmpMapper {
	@Select("select empno,ename,sal,hiredate from emp")
	public List<EmpVO> empListData();
}
