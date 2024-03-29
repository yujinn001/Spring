package com.sist.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.dao.*;
import java.util.*;
import com.sist.web.entity.*;

@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@PostMapping("board/board_update_ok")
	public String board_update_ok(BoardEntity vo,Model model)
	{
		BoardEntity dbvo=dao.findByNo(vo.getNo());
		String res="";
		if(dbvo.getPwd().equals(vo.getPwd()))
		{
			dao.save(vo);
			res="<script>"
			  + "location.href=\"/board/board_detail?no="+vo.getNo()+"\";"
			  + "</script>";
		}
		else
		{
			res="<script>"
			  + "alert(\"비밀번호가 틀립니다!!\");"
			  + "history.back();"
			  + "</script>";
		}
		
		return res; // 메인으로 가면 안됨! 단독 수행해야해서
	}
	@PostMapping("board/board_delete_ok")
	   public String board_delete_ok(int no,String pwd,Model model)
	   {
	   	BoardEntity dbvo=dao.findByNo(no);
	   	String res="";
	   	if(dbvo.getPwd().equals(pwd))
	   	{
	   		dao.delete(dbvo);
	   		res="<script>"
	   		   +"location.href=\"/board/board_list\";"
	   		   +"</script>";
	   	}
	   	else
	   	{
	   		res="<script>"
	   		   +"alert(\"비밀번호가 틀립니다!!\");"
	   		   +"history.back();"
	   		   +"</script>";
	   	}
	   	
	   	return res;
	   }

}
