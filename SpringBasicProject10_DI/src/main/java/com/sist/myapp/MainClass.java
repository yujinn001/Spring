package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	private StudentDAO dao;
	
	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		
		ApplicationContext app=
				new ClassPathXmlApplicationContext(new String[]{"application-context.xml","application-datasource.xml"});
		MainClass mc=(MainClass)app.getBean("mc");
		
		/*StudentVO vo=new StudentVO();
		vo.setName("홍길동");
		vo.setKor(70);
		vo.setEng(80);
		vo.setMath(78);
		mc.dao.studentInsert(vo);
		System.out.println("저장완료");*/
		List<StudentVO> list=mc.dao.studentListData();
		for(StudentVO vo:list)
		{
			System.out.println(vo.getName()+" "
					          +vo.getName()+" "
					          +vo.getKor()+" "
					          +vo.getEng()+" "
					          +vo.getMath()+" "
					          +vo.getTotal()+" "
					          +vo.getAvg());
		}
		StudentVO vo=mc.dao.studentDetailData(2);
			System.out.println(vo.getName()+" "
					          +vo.getName()+" "
					          +vo.getKor()+" "
					          +vo.getEng()+" "
					          +vo.getMath()+" "
					          +vo.getTotal()+" "
					          +vo.getAvg());
		}
}














