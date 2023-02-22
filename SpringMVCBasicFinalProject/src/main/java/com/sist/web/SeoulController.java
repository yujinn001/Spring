package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.SeoulDAO;

@Controller
public class SeoulController {
	@Autowired
	private SeoulDAO dao;
	@GetMapping("seoul/list.do")
	public String seoul_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize =20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end =(rowSize*curpage);
		map.put("start", start);
		map.put("end", end);
		List<SeoulVO> list=dao.seoulLocationListData(map);
		int totalpage=dao.seoulTotalPage();
		
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
	    model.addAttribute("totalpage", totalpage);
	    model.addAttribute("startPage", startPage);
	    model.addAttribute("endPage", endPage);
		model.addAttribute("list",list);
		return "seoul/list";
	}
	@GetMapping("seoul/detail.do")
	public String seoul_detail(int no, Model model)
	{
		SeoulVO vo= dao.seoulDetailData(no);
		String addr=vo.getAddress();
		String[] address=addr.split(" ");
		Map map=new HashMap();
		map.put("address", address[2].trim());
		List<FoodVO> list=dao.foodLocationData(map);
		
		model.addAttribute("list",list);
		model.addAttribute("vo",vo);
		return "seoul/detail";
	}
}




















