package com.sist.mapper;
import java.util.*;

import com.sist.dao.SeoulLocationVO;

// mapper => xml을 읽어서 구현
public interface SeoulMapper {
	public List<SeoulLocationVO> seoulListData();
	public SeoulLocationVO seoulDetailData(int no);
	//       resultType       id            parameterType
}
