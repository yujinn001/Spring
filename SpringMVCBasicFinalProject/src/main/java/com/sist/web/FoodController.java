package com.sist.web;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

import oracle.net.aso.i;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// <if> <choose> <where> <trim> <foreach>
// HandlerMapping이 foodController를 찾고 
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class FoodController {
	// DB만들기
	@Autowired
	private FoodDAO dao;
	
	/* 
	 *    GetMapping과 PostMapping 
	 *    -----------   -------------- <form> 태그 (post라고 쓰는 단어가 있을 때)
	 *    | <a>태그
	 */
	
	@GetMapping("food/category.do")
	public  String food_category(String no, Model model)
	{
		if(no==null)
			no="1";
		Map map =new HashMap();
		map.put("cno", no);
		List<CategoryVO> list=dao.categoryListData(map);
		model.addAttribute("list",list);
		return "food/category";
	}
	@GetMapping("food/list.do")
	public String food_list(int cno,Model model)
	{
		List<FoodVO> list=dao.foodListData(cno);
		CategoryVO vo=dao.categoryInfoData(cno);
		model.addAttribute("list",list);
		model.addAttribute("vo",vo);
		return "food/list";
	}
	//food/detail.do?fno=${fvo.fno }
	@GetMapping("food/detail")
	public String food_detail(int fno,Model model)
	{
		FoodVO vo=dao.foodDetailData(fno);
		model.addAttribute("vo",vo);
		return "food/detail";
	}
	@RequestMapping("food/find.do") //post와 get방식이 동시에 사용될 경우
	public String food_find(String addr,String page, Model model)
	{
		String s="";
		if(addr==null || addr.equals(" "))
		{
			s="all";
		}
		else
		{
			s=addr;
		}
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("ss", s);
		List<FoodVO> list=dao.foodFindData(map);
		
		model.addAttribute("list", list);
		return "food/find";
	}
}











