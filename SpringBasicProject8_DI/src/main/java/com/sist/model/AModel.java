package com.sist.model;

import org.springframework.stereotype.Component;

@Component("am") //일반 클래스 (MainClass, Jsoup, XML파싱, JSON 생성)
public class AModel {
	public void board()
	{
		System.out.println("게시판의 모든 기능이 있다");
	}
}
