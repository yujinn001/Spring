package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.config.EmpConfig;
import com.sist.dao.*;
// Ŭ������ Ŭ���� ���� ��ȣ ���� => XML
public class MainClass {
	// ���� => ���������� �����Ŀ� ���� => �ڵ� ���� ��û
	private EmpDAO dao; // ������ DAO�� ���ο� �����ش�
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		//MainClass�� new�� ������� �ʰ�!! xml������ �ҷ��ͼ� �ؾ� null���� �ȳ��´�
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
