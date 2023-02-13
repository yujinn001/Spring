package com.sist.spring1;
/*
 *  스프링의 1번째 목적은 의존성을 낮은 프로그램으로 만드는 것이다
 *  
 *  MainClass는  Hello 클래스에 의존한다
 */
public class MainClass {
	public static void main(String[] args) {
		Hello hello=new Hello();
		// new를 사용하면 결합성이 높은 프로그램
		String msg=hello.sayHello("홍길동");
		System.out.println(msg);
	}
}
