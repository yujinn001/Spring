package com.sist.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// XML,Container ȣ��
/*
 *   1) �������� ����� Ŭ���� ���� => Model,DAO,Manager...(����� ������ �ִ� Ŭ����)
 *   2) ���� : ����� ���� �������� => VO, DTO, Bean
 *   -------------------------------------------------------------------
 *   3) XML�� �̿��ؼ� ���
 *   4) ========================= ������ ���̺귯������ ó��(Application Context)
 *   5) ��ϵ� Ŭ������ ApplicationContext���� ���ͼ� ���� =====================> ����
 *   6) ApplicationContext���� ��ϵ� Ŭ������ �Ҹ�
 *   
 *      ������ ���̺귯��(�ڹ� �ҽ� �ڵ��� �Ұ���) <=========> ����� (���α׷��ӿ� ���)
 *                                       XML, Annotation => ��Ÿ ������
 *      ===============================
 *       ���� : ��ü ���� / ��ü �Ҹ� / ��ü ã�� ==> getBean() ==> DL
 *   7) ���� : ��ü�� ������ �� �ʿ��� �����Ͱ� ������ => DI
 *   ------------------------------------------- XML �� �޴���, Annotation�� �˻�
 *                                               ----------------------------
 *   => MVC (���̺귯��), Ŭ���� ������ (���� ���ռ�) => �����ÿ� �ٸ� Ŭ������ ������ ���� ���� (��������)                                            
 */
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		// ClassPath => src/main/java
		AModel a =(AModel)app.getBean("a");
		a.display();
		BModel b =(BModel)app.getBean("b");
		b.display();
		CModel c =(CModel)app.getBean("c");
		c.display();
	}
}
