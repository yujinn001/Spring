package com.sist.myapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.MemberVO;

@Controller
public class MemberController {
	@RequestMapping("member/insert.do")
	public String member_insert(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("utf-8");
		}catch(Exception ex) {}
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setAddress(address);
		vo.setSex(sex);
		vo.setTel(tel);
		
		request.setAttribute("vo", vo);
		return "member/inser_ok";
	}
	
	// request를 필요한 경우가 아니면 가급적 사용 금지 (클라이언트 ip)
	@RequestMapping("member/insert2.do") // GET,POST 동시에
	public String member_insert2(MemberVO vo,Model model)
	{
		// 전송 객체 => Model
		model.addAttribute("vo",vo); // request.setAttribute("vo", vo);
		return "member/insert_ok2";
	}
}
