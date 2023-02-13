package com.sist.di2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app2.xml");
		// <bean id ="sa1" class="com.sist.di1.Sawon"> => id 명칭
		Sawon sa2=(Sawon)app.getBean("sa2");
		System.out.println("사번 : "+sa2.getSabun() );
		System.out.println("이름 : "+sa2.getName() );
		System.out.println("직위 : "+sa2.getJob() );
		System.out.println("부서 : "+sa2.getDept() );
		System.out.println("연봉 : "+sa2.getPay() );
	}

}
