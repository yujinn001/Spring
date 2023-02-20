package com.sist.myapp;

public class MainClass {

	public static void main(String[] args) {
		StudentDAO dao =new StudentDAO();
		StudentVO vo=new StudentVO();
		
		// 트랜잭션 
		// 둘중 하나가 에러가 생겨 오류로 일괄처리가 되지 않는다.
		vo.setHakbun(7);
		vo.setName("이순신1");
		vo.setKor(50);
		vo.setEng(80);
		vo.setMath(90);
		
		StudentVO vo1=new StudentVO();
		vo1.setHakbun(8);
		vo1.setName("이순신");
		vo1.setKor(50);
		vo1.setEng(80);
		vo1.setMath(90);
		
		dao.studentInsert(vo, vo1);
	}

}
