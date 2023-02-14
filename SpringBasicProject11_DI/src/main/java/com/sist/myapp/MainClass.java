package com.sist.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

import java.util.*;
public class MainClass{
	private EmpDAO dao;

	public void setDao(EmpDAO dao) { // ���� �޾ƿ;� �ؼ� setter�� �ʿ��ϴ�
		this.dao = dao;
	}
	public static void main(String[] args) {
		// ���� ������ xml�� ��� => ApplicationContext
		// �ƴ� ��� AnnotationConfig~~
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
