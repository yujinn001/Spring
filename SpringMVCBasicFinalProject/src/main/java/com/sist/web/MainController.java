package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 컨틀롤러는 폴더당 1개씩 
@Controller // => 스프링 제어
public class MainController {
	@GetMapping("main/main.do")
	public String main_main()
	{
		return "main/main";
	}
}
