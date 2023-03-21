package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

@Controller
@RequestMapping("member/") // 중복 코드 => 경로명이 길 경우 사용
public class MemberFController {
	@Autowired
	MemberDAO dao;
	
	@GetMapping("join.do")
	public String member_join()
	{
		return "member/join";
	}
}
