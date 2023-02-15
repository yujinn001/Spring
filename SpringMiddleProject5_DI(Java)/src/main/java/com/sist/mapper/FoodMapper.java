package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import  com.sist.vo.*;
public interface FoodMapper {
	@Select("select fno, name,tel,address,type from project_food"
			+ " where cno=#{cno}")
	public List<FoodVO> foodListData(int cno); // getConnection, disConnection이 포함됨
	
}
