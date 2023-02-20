package com.sist.dao;
// OOP => 보완(AOP)
public class MovieDAO {
	public void getConnection()
	{
		System.out.println("오라클 연결...");
	}
	public void disConnection()
	{
		System.out.println("오라클 닫기");
	}
	public void select()
	{
		getConnection(); // 공통된 부분
		System.out.println("select 문장 수행 "); // 핵심 모듈
		disConnection(); // 공통 된 부분
	}
	public void insert()
	{
		getConnection();
		System.out.println("insert 문장 수행 ");
		disConnection();
	}
	public void update()
	{
		getConnection();
		System.out.println("update 문장 수행 ");
		disConnection();
	}
	public void delete()
	{
		getConnection();
		System.out.println("delete 문장 수행 ");
		disConnection();
	}
}
