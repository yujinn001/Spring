package com.sist.model;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
// 재사용 하는거는 클래스로 분리해서 사용한다

public class Model {
	private FoodDAO fdao;
	private GoodsDAO gdao;
	private RecipeDAO rdao;
	
	public void setFdao(FoodDAO fdao) {
		this.fdao = fdao;
	}

	public void setGdao(GoodsDAO gdao) {
		this.gdao = gdao;
	}

	public void setRdao(RecipeDAO rdao) {
		this.rdao = rdao;
	}
	
	// 기능별로 분리
	public void recipeListData()
	{
		List<RecipeVO> list=rdao.recipeListData();
		for(RecipeVO vo: list)
		{
			System.out.println(vo.getNo()+". "+vo.getTitle()+"("+vo.getChef()+")");
		}
	}
	public void foodListData()
	{
		List<FoodVO> list=fdao.foodListData();
		for(FoodVO vo: list)
		{
			System.out.println(vo.getFno()+". "+vo.getName()+"("+vo.getType()+")");
		}
	}
	public void goodsListData()
	{
		List<GoodsVO> list=gdao.goodsListData();
		for(GoodsVO vo: list)
		{
			System.out.println(vo.getNo()+". "+vo.getName()+"("+vo.getPrice()+")");
		}
	}
}































