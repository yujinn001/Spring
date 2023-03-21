package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.sist.web.*;
import com.sist.web.dao.CategoryDAO;
import com.sist.web.dao.FoodDAO;
import com.sist.web.entity.CategoryEntity;
import com.sist.web.entity.FoodEntity;

@Controller
@RequestMapping("food/")
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@Autowired
	private CategoryDAO cDao;
	@GetMapping("food_list")
	public String good_list(int cno,Model model)
	{
		  CategoryEntity cvo=cDao.findByCno(cno);
		  List<FoodEntity> list = dao.findByCno(cno);
		  for(FoodEntity vo:list)
		  {
			  String address=vo.getAddress();
			  address=address.substring(0,address.lastIndexOf("지"));
			  vo.setAddress(address);
			  
			  String poster=vo.getPoster();
			  poster=poster.substring(0,poster.indexOf("^"));
			  poster=poster.replace("#", "&");
			  vo.setPoster(poster);
		  }
		  model.addAttribute("cvo", cvo);
	      model.addAttribute("list", list);
	      model.addAttribute("main_html", "food/food_list");
	      return "main";

	}
	@GetMapping("food_detail")
	public String food_detail(int fno,Model model)
	{
		FoodEntity vo=dao.findByFno(fno);
		String poster=vo.getPoster();
		List<String> pList=new ArrayList<String>();
		StringTokenizer st=new StringTokenizer(poster,"^");
		while(st.hasMoreTokens())
		{
			pList.add(st.nextToken());
		}
		model.addAttribute("pList",pList);
		String addr1=vo.getAddress();
		addr1=addr1.substring(0,addr1.lastIndexOf("지"));
		model.addAttribute("addr1",addr1.trim());
		model.addAttribute("vo",vo);
		model.addAttribute("main_html","food/food_detail");
		return "main";
	}
}




















