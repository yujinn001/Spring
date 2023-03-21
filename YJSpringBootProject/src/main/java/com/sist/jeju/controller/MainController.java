package com.sist.jeju.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.jeju.entity.*;
import com.sist.jeju.dao.*;

@Controller
public class MainController {
	@Autowired
	private JejuDAO dao;
	
	@GetMapping("/")
	public String jeju_main(Model model)
	{
		List<jejuHotelEntity> sList=dao.jejuStarListData();
		List<jejuHotelEntity> list=dao.jejucategoryListData();
		
		
		for(jejuHotelEntity vo:list )
		{
			String name=vo.getName();
			if(name.length()>7) {
				name=name.substring(0,7)+"...";
				vo.setName(name);
			}
			vo.setName(name);
		}
		model.addAttribute("sList",sList);
		model.addAttribute("list",list);
		model.addAttribute("main_html","main/home");
		return "main";
	}
	
	
	
	
	
	@GetMapping("/jeju/main") // 제주 확인용
	public String jeju_list(Model model)
	{
		List<jejuHotelEntity> list=dao.jejucategoryListData();
		
		
		for(jejuHotelEntity vo:list )
		{
			String name=vo.getName();
			if(name.length()>7) {
				name=name.substring(0,7)+"...";
				vo.setName(name);
			}
			vo.setName(name);
		}
		model.addAttribute("list",list);
		return "jeju/jeju_main";
	}
}
