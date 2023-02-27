package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.CookieStore;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.dao.SeoulDAO;

@Controller
public class SeoulController {
	@Autowired
	private SeoulDAO dao;
	@GetMapping("seoul/list.do")
	public String seoul_list(String page,Model model,HttpServletRequest request)//request로 값을 받아온다
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
		
		// 쿠키 관련
		List<SeoulVO> cList=new ArrayList<SeoulVO>();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith("seoul"))
				{
					String no=cookies[i].getValue();
					SeoulVO vo=dao.seoulDetailData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		model.addAttribute("cList",cList);
		return "seoul/list";
	}
	//<a href="../seoul/detail_before.do?no=${vo.no }">
	@GetMapping("seoul/detail_before.do")
	public String seoul_detail_before(String no,HttpServletResponse response,RedirectAttributes ra)// response로 쿠키 저장
	{
		Cookie cookie=new Cookie("seoul"+no, no);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		
		// 브라우저로 전송
		response.addCookie(cookie);
		ra.addAttribute("no",no);//"no"=> ?no= / no => no
		
		return "redirect:detail.do";
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




















