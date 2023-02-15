package com.sist.myapp;
import java.util.*;

import javax.crypto.spec.IvParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
import com.sist.service.EmpDeptService;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@Component("mc") 
public class MainClass {
	@Autowired // 1개씩 받아야한다 (Autowired)
	private EmpDAO edao;
	@Autowired
	private DeptDAO ddao;
	@Autowired
	private EmpDeptService es;
	
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml");
				//new AnnotationConfigApplicationContext(new String[] {"application-context.xml","application-datasource.xml"});
		MainClass mc=app.getBean("mc",MainClass.class);// 리턴형이 메인 클래스
		List<EmpVO> eList=mc.edao.empListData();
		List<DeptVO> dList=mc.ddao.deptListData();
		System.out.println("============사원 목록============");
		for(EmpVO vo: eList)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getSal());
		}
		System.out.println("=============부서 목록===========");
		for(DeptVO vo:dList)
		{
			System.out.println(vo.getDeptno()+" "+vo.getDname()+" "+vo.getLoc());
			
		}
		System.out.println("============서비스 이용===========");
		List<EmpVO> list=mc.es.empListData();
		List<DeptVO> list2=mc.es.deptListData();
		System.out.println("============사원 목록============");
		for(EmpVO vo: list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getSal());
		}
		System.out.println("=============부서 목록===========");
		for(DeptVO vo:list2)
		{
			System.out.println(vo.getDeptno()+" "+vo.getDname()+" "+vo.getLoc());
			
		}
		
	}

}
