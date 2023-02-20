package com.sist.aop;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.aspectj.lang.ProceedingJoinPoint;
/*
 *   AOP의 적용 부분
 *   public List<MovieVO> movieListData()
 *   {
 *   	List<MovieVO> list = new ArrayList<MovieVO>();
 *   	try
 *   	{
 *   		getConnection() => Before
 *        ======================
 *         around => setAutoCommit (false) 
 *          오라클 처리
 *         around => commit()
 *        ======================
 *   	}catch(Exception ex)
 *   	{
 *   	   오류 처리
 *   		ex.printStackTrace() => AfterThrowing
 *   	}
 *   	finally
 *   	{
 *   		오라클 닫기
 *   		disConneciont() => After
 *   	}
 *   	return; => AfterReturning
 *   }
 */
import com.sist.model.*;
import java.util.*;
import lombok.Setter;
public class ModelAspect {
	// app.xml에서 값을 받아올 부분
	@Setter
	private EmpDAO dao;
	
	public void before()
	{
		//getConnection
		System.out.println("before Call...: 시작전");
		dao.getConntecion();
	}
	public void after()
	{
		//disConnection
		System.out.println("after Call...: finally");
		dao.disConnection();
	}
	/*	 Before 위치
	 *   try
	 *   {
	 *      =================== around 시작
	 *       소스 코딩
	 *      =================== around 끝
	 *    } catch(exception e){
	 *    	 afterThrowing : 오류 발생시 처리
	 *    }
	 *    finally
	 *    {
	 *       after
	 *	  }
	 *
	 *    return afterReturning : 정상 수행시 처리
	 *    
	 *    뉴스 읽기 => before
	 *    뉴스를 List => 핵심
	 *    해당 화면 전송 => afterReturning => request로 브라우저 전송
	 *    
	 *    반복 수행이 많은 경우에 주로 처리 
	 *    -------------------------
	 *     머신 러닝
	 *     =======================
	 *     데이터 수집 => Before
	 *     =======================
	 *     데이터 전처리
	 *     데이터 분석
	 *     데이터 통계
	 *     ---------- + 딥러닝
	 *     ======================= 핵심
	 *     데이터 예측 => finally(after)
	 *     =======================
	 */
	public Object around(ProceedingJoinPoint jp) throws Throwable // Exception의 상위 클래스 : Throwable
	{
		System.out.println("around Call...: try위 ~ try종료전 ");
		Object obj=null;
		// 수행 시간 계산
		long start =0;
		long end=0;
		try
		{
			start=System.currentTimeMillis();
			System.out.println("Client 요청 메소드 : "+jp.getSignature().getName());
			obj=jp.proceed();// 메소드 호출하는 과정
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			end=System.currentTimeMillis();
			System.out.println("수행 시간 : "+(end-start)); // 통계
		}
		return obj;
	}
	public void afterReturning(Object obj) throws Throwable
	{
		// 결과값을 받아서 출력 => web에서 return값을 먼저 처리 => 자동 로그인, ID저장..
		System.out.println("afterReturning Call..");
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob());
		}
	}
	public void afterThrowing(Throwable ex) throws Throwable
	{
		System.out.println("afterThrowing Call..");
		// catch 수행
		System.out.println(ex.getMessage()); // web=> alert
	}
}
