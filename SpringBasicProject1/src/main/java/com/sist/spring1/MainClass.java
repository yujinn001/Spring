package com.sist.spring1;
/*
 *  �������� 1��° ������ �������� ���� ���α׷����� ����� ���̴�
 *  
 *  MainClass��  Hello Ŭ������ �����Ѵ�
 */
public class MainClass {
	public static void main(String[] args) {
		Hello hello=new Hello();
		// new�� ����ϸ� ���ռ��� ���� ���α׷�
		String msg=hello.sayHello("ȫ�浿");
		System.out.println(msg);
	}
}
