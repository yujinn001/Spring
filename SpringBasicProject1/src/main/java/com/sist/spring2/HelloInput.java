package com.sist.spring2;
/* FactoryPattern: 클래스를 여러개 묶어서 관리
 * 클래스 : 컴포넌트, 관리 : 컨테이너
 * Spring: 클래스 관리자, 컨테이너
 */
public class HelloInput implements Hello{
     @Override
     public String sayHello(String name)
     {
  	   return name+"님 환영합니다!!";
     }
}
