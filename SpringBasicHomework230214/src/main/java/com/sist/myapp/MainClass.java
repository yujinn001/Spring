package com.sist.myapp;
import com.sist.dao.*;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {
	private DeptDAO dao;
	
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext(new String[]{"application-context.xml","application-datasource.xml"});
		MainClass mc=(MainClass)app.getBean("mc");
		List<DeptVO> list=mc.dao.deptListData();
		for(DeptVO vo: list)
		{
			System.out.println(vo.getDeptno()+" "
					          +vo.getDname()+" "
					          +vo.getLoc());
		}
		DeptVO vo= mc.dao.deptDetailData(40);
		System.out.println(vo.getDeptno()+" "
		          +vo.getDname()+" "
		          +vo.getLoc());
	}

}
