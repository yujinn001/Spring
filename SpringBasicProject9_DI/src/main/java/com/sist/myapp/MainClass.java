package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	private FoodDAO dao;
	
	public void setDao(FoodDAO dao) {
		this.dao = dao;
	}
	
	public static void main(String[] args) {
		String[] xml= {"application-context.xml","application-datasource.xml"};
		ApplicationContext app=
				new ClassPathXmlApplicationContext(xml);
		MainClass mc=(MainClass)app.getBean("mc");
		List<FoodVO> list=mc.dao.foodListData();
		for(FoodVO vo: list)
		{
			System.out.println("������ȣ:"+vo.getFno());
			System.out.println("������:"+vo.getName());
			System.out.println("�ּ�:"+vo.getAddress());
			System.out.println("=============================");
		}
		Scanner sc=new Scanner(System.in);
		System.out.print("��ȣ�� �Է��ϼ���");
		int fno=sc.nextInt();
		FoodVO vo =mc.dao.foodDetailData(fno);
		System.out.println("������:"+vo.getName());
		System.out.println("�ּ�:"+vo.getAddress());
		System.out.println("�����ð�:"+vo.getTime());
		System.out.println("����:"+vo.getParking());
		System.out.println("��������:"+vo.getType());
	}

}
