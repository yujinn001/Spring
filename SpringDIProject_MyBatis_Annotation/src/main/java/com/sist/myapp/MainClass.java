package com.sist.myapp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.model.*;
@Component // 일반 클래스
// id = 사용자 정의, 자동 지정 (클래스명 => 첫자만 소문자)
public class MainClass {
	@Autowired
	private Model model; // new Model() => 주소값을 받으려면  SetXxx / @Autowired
	
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		System.out.println("========Menu=============");
		System.out.println("1. 레시피");
		System.out.println("2. 맛집");
		System.out.println("3. 상품");
		System.out.println("=========================");
		Scanner sc=new Scanner(System.in);
		System.out.println("메뉴 선택: ");
		int no=sc.nextInt();
		if(no==1)
		{
			mc.model.recipeListData();
		}
		if(no==2)
		{
			mc.model.foodListData();
		}
		if(no==3)
		{
			mc.model.goodsListData();
		}
	}
}
