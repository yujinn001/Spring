package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("select no, title,addr,score,rownum from jejufood where rownum<=30")
	public List<JejuFoodVO> foodListData();
}
