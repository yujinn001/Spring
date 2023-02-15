package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.FoodConfig;
import com.sist.service.FoodService;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

import java.util.*;
@Component// 메모리 할당
public class MainClass {
	@Autowired
	private FoodService fs;
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(FoodConfig.class);
		MainClass  mc=(MainClass)app.getBean("mainClass");
		List<CategoryVO> cList=mc.fs.categoryListData();
		for(CategoryVO vo:cList)
		{
			System.out.println(vo.getCno()+". "+vo.getTitle());
		}
		System.out.println("==================================");
		Scanner sc= new Scanner(System.in);
		System.out.println("카테고리 번호를 선택해라(91~150) ");
		int cno=sc.nextInt();
		List<FoodVO> fList=mc.fs.foodListData(cno);
		for(FoodVO vo: fList)
		{
			System.out.println(vo.getFno()+". "+vo.getName()+"("+vo.getAddress()+")");
		}
	
	}
}
