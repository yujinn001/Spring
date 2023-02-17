package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface LocationMapper {
	@Select("select title,addr,price from jejuLocation")
	public List<JejuLocationVO> locationListData();
}
