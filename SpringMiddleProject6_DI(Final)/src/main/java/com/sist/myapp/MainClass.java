package com.sist.myapp;
import java.util.*; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.SeoulConfig;
import com.sist.dao.SeoulDAO;
import com.sist.vo.*;
// MainClass는 DAO를 가져다 사용한다
@Component // 일반 클래스다! 
public class MainClass {
	@Autowired
	private SeoulDAO dao;
	public static void main(String[] args) {
		//ApplicationContext app=
		//		new ClassPathXmlApplicationContext("app.xml");
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(SeoulConfig.class);
		
		System.out.println("============== 메뉴 ===============");
		System.out.println("1.명소");
		System.out.println("2.자연&관광");
		System.out.println("3.쇼핑");
		System.out.println("4.호텔");
		System.out.println("5.게스트하우스");
		System.out.println("=============================");
		String[] table= {"","location","nature","shop","hotel","guest"};
		Scanner sc= new Scanner(System.in);
		System.out.println("메뉴 선택:");
		int menu=sc.nextInt();
		
		Map map=new HashMap();
		map.put("seoul_tbl", "seoul_"+table[menu]);
		
		MainClass mc=app.getBean("mainClass",MainClass.class); //@Component ("id") 가 없는 경우는 처음을 소문자로
		List<SeoulVO> list=mc.dao. seoulListData(map);
		
		for(SeoulVO vo:list)
		{
			System.out.println(vo.getNo()+" "+vo.getTitle()+"("+vo.getAddress()+")");
		}
		
		
	}

}
