package com.sist.spring2;
/* FactoryPattern: Ŭ������ ������ ��� ����
 * Ŭ���� : ������Ʈ, ���� : �����̳�
 * Spring: Ŭ���� ������, �����̳�
 */
public class HelloInput implements Hello{
     @Override
     public String sayHello(String name)
     {
  	   return name+"�� ȯ���մϴ�!!";
     }
}
