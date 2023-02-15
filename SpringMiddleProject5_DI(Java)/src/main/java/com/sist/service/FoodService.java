package com.sist.service;

import java.util.List;
import java.util.logging.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// DAO여러개를 통합(DI)
// 99.9% => DAO Vs Service의 차이점

import com.sist.mapper.CategoryMapper;
import com.sist.mapper.FoodMapper;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
@Service //메모리 할당
public class FoodService {
	@Autowired // 주소값 받기(setter대신)
	//private인데 접근이 가능하다
	private FoodMapper fMapper;
	@Autowired
	private CategoryMapper gMapper;
	
	public List<CategoryVO> categoryListData()
	{
		return gMapper.categoryListData();
	}
	public List<FoodVO> foodListData(int cno)
	{
		return fMapper.foodListData(cno);
		
	}
}
