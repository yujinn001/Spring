package com.sist.dao;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 메모리 할당 <bean id="dao">
import com.sist.mapper.SeoulMapper;

@Repository("dao")
public class SeoulDAO {
	
	@Autowired // 자동주입
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulListData()
	{
		return mapper.seoulListData();
	}
}
