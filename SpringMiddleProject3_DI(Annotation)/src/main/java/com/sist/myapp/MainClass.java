package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.dao.SeoulDAO;
import com.sist.dao.SeoulVO;

// 메모리 할당
@Component("mc")
public class MainClass {
	@Autowired // 같은 객체형이 있는 경우에는 에러 발생
	
	private SeoulDAO dao;
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		List<SeoulVO> list=mc.dao.seoulListData();
		for(SeoulVO vo: list)
		{
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
	}
}
