package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.GoodConfig;
import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsCategoryVO;
import com.sist.vo.GoodsVO;

import java.util.*;
@Component // 메모리 할당
public class MainClass {
	@Autowired
	private GoodsDAO dao;
	public static void main(String[] args) {
		//AnnotationConfigApplicationContext app=
		//		new AnnotationConfigApplicationContext(GoodConfig.class);
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		System.out.println("============== 메뉴 ===============");
		System.out.println("1.전체");
		System.out.println("2.베스트");
		System.out.println("3.특가");
		System.out.println("4.신상");
		System.out.println("=============================");
		String[] table= {"","all","best","new","special"};
		Scanner sc= new Scanner(System.in);
		System.out.println("메뉴 선택:");
		int menu=sc.nextInt();
		
		Map map=new HashMap();
		map.put("goods_tbl", "goods_"+table[menu]);
		/*List<GoodsCategoryVO> clist=mc.dao.categoryListData();
		for(GoodsCategoryVO vo: clist)
		{
			System.out.println(vo.getCno()+"."+vo.getCate_name());
		}*/
		MainClass mc=(MainClass)app.getBean("mainClass"); //  앞자리는 소문자
		List<GoodsVO> glist =mc.dao.goodsListData(map);
		for(GoodsVO vo:glist)
		{
			System.out.println(vo.getNo()+"."+vo.getGoods_name()+" "+vo.getGoods_price());
		}
	}
}
