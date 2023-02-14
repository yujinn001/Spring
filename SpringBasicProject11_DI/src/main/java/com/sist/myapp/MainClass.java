package com.sist.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

import java.util.*;
public class MainClass{
	private EmpDAO dao;

	public void setDao(EmpDAO dao) { // 값을 받아와야 해서 setter가 필요하다
		this.dao = dao;
	}
	public static void main(String[] args) {
		// 설정 파일이 xml일 경우 => ApplicationContext
		// 아닌 경우 AnnotationConfig~~
		ApplicationContext app= 
				new ClassPathXmlApplicationContext("application-datasource.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		List<EmpVO> list=mc.dao.empListData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "
					          +vo.getEname()+" "
					          +vo.getJob());
		}
		EmpVO vo=mc.dao.empDetailData(7788);
		System.out.println(vo.getEmpno()+" "
				          +vo.getEname()+" "
				          +vo.getJob());
	}

}
