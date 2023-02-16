package com.sist.vo;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

// MyBatis=> 변수명 = 컬럼명 이 동일하면 설정하지 않는다
// 컬럼명으로 변수명을 해야 사용하기 편하다 => 아닐 경우 일일이 as 별칭명을 작성해줘야한다 (alias)

/*
 *   select empno,hiredate,ename from....
 *          ----------------------
 *           setEmpno()
 */
// Q1. 테이블이 다를 경우 서브쿼리로 어떻게 값을 가져오는지
// Q2. 컬럼명이 다를 경우 alias를 사용해서 어떻게 값을 가져오는지 
public class EmpVO {
	private int empno,sal,deptno,rank;
	private String ename,job;
	private Date regdate;
	private String dname,loc; // 서브쿼리 alias
	private int grade; // 서브쿼리 alias
}
