package com.sist.myapp;
// 자바로 환경 설정
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.*;
import com.sist.dao.*;
public class MainClass2 {
	private StudentDAO dao;
	
	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(StudentConfig.class); // 파일 사용 (파일명).class
		MainClass2 mc=(MainClass2)app.getBean("mc");
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
		

	}

}
