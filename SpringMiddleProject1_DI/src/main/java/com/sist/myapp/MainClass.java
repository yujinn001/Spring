package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	private SeoulDAO dao;
	
	public void setDao(SeoulDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		List<SeoulLocationVO> list=mc.dao.seoulListData();
		for(SeoulLocationVO vo:list)
		{
			System.out.println("명소 :"+vo.getTitle());
			System.out.println("주소 :"+vo.getAddress());
			System.out.println("설명 :"+vo.getMsg());
			System.out.println("============================");
		}
	}

}
