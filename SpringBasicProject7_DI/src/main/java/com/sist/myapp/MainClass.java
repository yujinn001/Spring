package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.config.EmpConfig;
import com.sist.dao.*;
// 클래스와 클래스 간의 상호 연결 => XML
public class MainClass {
	// 주입 => 스프링에서 생성후에 주입 => 자동 주입 요청
	private EmpDAO dao; // 생성된 DAO를 메인에 보내준다
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		//MainClass를 new를 사용하지 않고!! xml내용을 불러와서 해야 null값이 안나온다
		/*ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");*/
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(EmpConfig.class);
		MainClass mc= (MainClass)app.getBean("mc");
		List<EmpVO> list=mc.dao.empListData();
		for(EmpVO vo: list)
		{
			System.out.println(vo.getEmpno()+" "
					          +vo.getEname()+" "
					          +vo.getJob());
		}
	}
}
