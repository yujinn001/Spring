package com.sist.web;
import java.util.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 컨트롤러에서는 @Component라고 쓰면 안된다
// Model => 반드시 (@Controller, @RestController)
@Controller
public class EmpController {
	@Autowired
	private EmpDAO dao;
	
	@GetMapping("emp/list.do")
	public String emp_list(Model model)
	{
		List<String> list=dao.empNameListData();
		model.addAttribute("list",list);
		return "emp/list";
	}
	
	@PostMapping("emp/info.do")
	public String emp_info(Model model, String[] names)
	{
		Map map=new HashMap();
		map.put("names", names);
		List<EmpVO> list=dao.empInfoData(map);
		
		model.addAttribute("list",list);
		return "emp/info";
	}
}
