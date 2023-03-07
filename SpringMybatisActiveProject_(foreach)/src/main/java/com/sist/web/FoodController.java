package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	/*
	 * Model,  => jsp�? 값을 ?��?��(Model?�� ?��?��객체) => ?��면에 출력?�� ?��?��?�� ?��?��(forward=> return "경로�?/?��?���?")
	 * RedirectAttributes =>? ???�� ?��?��
	 * 			return "redirect:detail.do?no=1"
	 * HttpServletRequest : Cookie ?���?
	 * HttpServltResponse : Cookie ?��?��, File Download
	 * HttpSession : ?��?�� �??��
	 * 
	 *  ?���? ?��?��?�� : page,no...,�??��?�� ====> String,?��?�� ?��?��?��?��?���? 받을 ?�� ?��?��
	 *  커맨?�� 객체: ~VO
	 *  checkbox => String[]
	 *  List => name=a[0] name=a[1]
	 */
	@GetMapping("food/list.do")
	public String food_list(String page,Model model) //Model, RedirectAttributes,HttpServletRequest,HttpServltResponse,HttpSession
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page); // ?��?�� ?��?���?
		Map map =new HashMap();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		List<FoodVO> list=dao.foodListData(map);
		int totalpage=dao.foodTotalPage();
				
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		return "food/list";
	}
	@PostMapping("food/find.do")
	public String food_find(String[] types,String ss,Model model)
	{
		Map map=new HashMap();
		map.put("typeArr", types); //MyBatis�� �����ִ� ��
		map.put("ss", ss);
		
		List<FoodVO> list=dao.foodFindData(map);
		int count=dao.foodFindCount(map);
		
		model.addAttribute("list",list); // �������� �����ִ� ��
		model.addAttribute("count",count);
		return "food/find";
	}
}

























