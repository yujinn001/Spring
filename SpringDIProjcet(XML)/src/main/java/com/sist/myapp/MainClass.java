package com.sist.myapp;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.sist.sawon.*;
public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext app=
				new GenericXmlApplicationContext("app.xml");
		Sawon sa=app.getBean("sa1",Sawon.class);
		sa.print();
		app.close(); // 소멸 (생명주기)
	}

}
