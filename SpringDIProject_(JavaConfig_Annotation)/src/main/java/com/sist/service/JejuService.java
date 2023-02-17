package com.sist.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.mapper.FoodMapper;
import com.sist.mapper.LocationMapper;
import com.sist.vo.JejuFoodVO;
import com.sist.vo.JejuLocationVO;

@Service
public class JejuService {
	@Autowired
	private FoodMapper fMapper;
	@Autowired
	private LocationMapper lMapper;
	
	//@Select("select no, title,addr,score,rownum from jejufood where rownum<-30")
	public List<JejuFoodVO> foodListData()
	{
		return fMapper.foodListData();
	}
	
	//@Select("select title,addr,price from jejuLocation")
	public List<JejuLocationVO> locationListData()
	{
		return lMapper.locationListData();
	}


}
