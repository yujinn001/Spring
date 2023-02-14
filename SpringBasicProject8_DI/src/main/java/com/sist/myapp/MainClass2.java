package com.sist.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.config.ModelConfig;
import com.sist.model.AModel;
import com.sist.model.BModel;
import com.sist.model.CModel;

public class MainClass2 {

	public static void main(String[] args) {
		/*ApplicationContext app=
				new ClassPathXmlApplicationContext("app2.xml");*/
		// app2.xml에 아이디 명칭이 없는 경우 클래스 파일의 어노테이션 부분에 "아이디명"을 추가 해준다
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(ModelConfig.class);
		AModel a=(AModel)app.getBean("am");
		a.board();
		BModel b=(BModel)app.getBean("BModel"); 
		                   // 자동 id지정 => class명이 자동 아이디로 지정 => 클래스 이름과 동일
		b.member();
		CModel c=new CModel();
		c.food();

	}

}
