package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.mapper.*;

@Service // 통합 해서 사용하는 경우
public class EmpDeptService {
	@Autowired
	private EmpMapper eMapper;
	@Autowired
	private DeptMapper dMapper;
	
	public List<DeptVO> deptListData()
	{
		return dMapper.deptListData();
	}
	public List<EmpVO> empListData()
	{
		return eMapper.empListData();
	}
}
