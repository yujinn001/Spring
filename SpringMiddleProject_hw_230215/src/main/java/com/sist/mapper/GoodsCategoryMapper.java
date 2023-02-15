package com.sist.mapper;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsCategoryVO;

// interface는 메모리 할당 하지 않는다
import java.util.*;
public interface GoodsCategoryMapper {
	@Select("select cno,cate_name from project_goods_category order by cno")
	public List<GoodsCategoryVO> categoryListData();
}
