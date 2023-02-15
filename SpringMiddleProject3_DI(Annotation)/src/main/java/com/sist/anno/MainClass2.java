package com.sist.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("main")
public class MainClass2 {
	@Autowired // 자동 구현 (setter에 값을 넣는거 대신 쓴다)
	// 특정 객체를 지정한다
	@Qualifier("mysql") 
	//@Autowired+@Qualifier("mysql") =@Resource(name="mysql)
	private MyDAO dao; // 갖고오는 데이터가 2개 =>상속을 받아서 => mysql,oracle
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass2 mc=(MainClass2)app.getBean("main");
		mc.dao.connect();
	}

}
