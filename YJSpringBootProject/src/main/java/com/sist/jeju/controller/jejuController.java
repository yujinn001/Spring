package com.sist.jeju.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.jeju.entity.*;
import com.sist.jeju.dao.*;

@Controller
public class jejuController {
	@Autowired
	private JejuDAO dao;
	
	@GetMapping("/main")
	public String jeju_main(Model model)
	{
		List<jejuEntity> list=dao.jejucategoryListData();
		
		
		for(jejuEntity vo:list )
		{
			String name=vo.getName();
			if(name.length()>7) {
				name=name.substring(0,7)+"...";
				vo.setName(name);
			}
			vo.setName(name);
		}
		model.addAttribute("list",list);
		model.addAttribute("main_content","main/home");
		return "main";
	}
	@GetMapping("/jeju/main") // 제주 확인용
	public String jeju_list(Model model)
	{
		List<jejuEntity> list=dao.jejucategoryListData();
		
		
		for(jejuEntity vo:list )
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
