package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.BoardDAO;

@RestController // 데이터 전송??
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping(value="board/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String board_list(int page)
	{
		Map map=new HashMap();
		map.put("start",(page*10)-9);
		map.put("end",page*10);
		List<BoardVO> list=dao.boardListData(map);
		int totalpage=dao.boardTotalPage();
		/*
		 *  [{no:1,....,curpage:1,totalpage:3},{no:2...}]
		 */
		//JSON 변환
		JSONArray arr=new JSONArray();
		int i=0;
		for(BoardVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("no", vo.getNo());
			obj.put("subject", vo.getSubject());
			obj.put("name", vo.getName());
			obj.put("dbday", vo.getDbday());
			obj.put("hit", vo.getHit());
			if(i==0) // 배열의 맨처음만 curpage,totalpage를 추가해줌
			{
				obj.put("curpage", page);
				obj.put("totalpage", totalpage);
			}
			arr.add(obj);
			i++;
		}
		return arr.toJSONString();
	}
	@GetMapping("board/insert_vue.do")
	public String board_insert(BoardVO vo)
	{
		dao.boardInsert(vo);
		return "";
	}
	
	@GetMapping(value = "board/detail_vue.do",produces = "text/plain;charset=UTF-8")
	public String board_detail_vue(int no)
	{
		BoardVO vo=dao.boardDetailData(no);
		JSONObject obj=new JSONObject();
		obj.put("no", vo.getNo());
		obj.put("subject", vo.getSubject());
		obj.put("name", vo.getName());
		obj.put("dbday", vo.getDbday());
		obj.put("hit", vo.getHit());
		obj.put("content", vo.getContent());
		
		return obj.toJSONString();
	}
	@GetMapping(value = "board/update_vue.do",produces = "text/plain;charset=UTF-8")
	public String board_update_vue(int no)
	{
		BoardVO vo=dao.boardDetailData(no);
		JSONObject obj=new JSONObject();
		obj.put("no", vo.getNo());
		obj.put("subject", vo.getSubject());
		obj.put("name", vo.getName());
		obj.put("content", vo.getContent());
		
		return obj.toJSONString();
	}
	@GetMapping("board/update_ok_vue.do") // 한글을 보내는게 없어서 produces를 안해도 된다
	public String board_update_ok_vue(BoardVO vo) // 보낼 값이 많을 때 BoardVO를 사용해서 한다
	{
		String res=dao.boardUpdate(vo);
		return res;
	}
	@GetMapping("board/delete_vue.do")
	public String board_delete_vue(int no,String pwd)
	{
		String res=dao.boardDelete(no, pwd);
		System.out.println("컨트롤러 res"+res);
		return res;
	}
}

















