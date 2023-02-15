package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;
import com.sist.vo.SeoulVO;

// DAO 는 mapper를 가져다 사용하고
// IOC
@Repository // DAO는 리포지토리 // 메모리 할당
public class SeoulDAO {
	@Autowired //자동 생성 (setter의 역할) // 주소값을 넣어라(스프링 내부에 있는 주소값을 여기에 넣어달라)
	private SeoulMapper mapper;
	public List<SeoulVO> seoulListData(Map map)
	{
		return mapper.seoulListData(map);
	}
}
