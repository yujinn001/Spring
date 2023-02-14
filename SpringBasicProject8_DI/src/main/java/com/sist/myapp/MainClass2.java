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
		// app2.xml�� ���̵� ��Ī�� ���� ��� Ŭ���� ������ ������̼� �κп� "���̵��"�� �߰� ���ش�
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(ModelConfig.class);
		AModel a=(AModel)app.getBean("am");
		a.board();
		BModel b=(BModel)app.getBean("BModel"); 
		                   // �ڵ� id���� => class���� �ڵ� ���̵�� ���� => Ŭ���� �̸��� ����
		b.member();
		CModel c=new CModel();
		c.food();

	}

}
