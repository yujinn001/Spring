package com.sist.dao;

public class MyDAO { // 메모리 할당
	private String url,user,password;
	
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public MyDAO(String driver) // 생성자를 통해 값을 넣어야 하는지
	{
		System.out.println("driver:"+driver);
	}
	public void getConnection()
	{
		 System.out.println("URL:"+url);
		 System.out.println("USER:"+user);
		 System.out.println("Password:"+password);
	}
}
