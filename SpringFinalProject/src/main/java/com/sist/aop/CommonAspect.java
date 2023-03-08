package com.sist.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
// 공통 모듈 => 공통으로 적용되는 기능을 모아서 관리 => 트랜잭션, 보안(제작되어 있다)
/*
 *  트랜잭션: @Transactional
 *    conn.setAutoCommit(false)
 *      SQL
 *      SQL
 *      ...
 *      conn.commit()
 *      
 *      => conn.rollback()
 *    보안 : 인증 / 인가
 *    => 사용자 정의 : 로그파일 => 빅데이터 (데이터 수집, 데이터 전처리...) => 데이터 예측
 *                           데이터 전처리 + 데이터 분석
 *                           -------------------- 딥러닝
 *    어떤 메소드에서 처리 : PointCut
 *    어느 위치에서 대입 : JoinPoint
 *    ---------------------------- Advice (여러개: Aspect)
 *    
 *    public void display()
 *    {
 *        @Before
 *        try
 *        {
 *        }catch(exception ex)
 *        {
 *        	@After-throwing
 *        }
 *        finally
 *        {
 *        	@After
 *        }
 *        
 *        return @After-Returning
 *    }
 */
import org.springframework.web.context.request.ServletRequestAttributes;
import com.sist.vo.*;
import java.util.*;
import com.sist.openapi.*;
import com.sist.dao.FoodDAO;

@Aspect
@Component
public class CommonAspect {
	@Autowired
	private FoodDAO dao;
	
	@Autowired
	private NaverNewsManager mgr;
	
	@Around("execution(* com.sist.web.*Controller.*(..)))") // Controller전체 포함
	public Object around(ProceedingJoinPoint jp) throws Throwable{ 
		// 메소드 실행한 시간 체크해서 출력하기
		Object obj=null;
		long start=System.currentTimeMillis();
		System.out.println("=============================");
		System.out.println("클라이언트 접속 요청전 : "+jp.getSignature().getName());
		obj=jp.proceed(); // 메소드 호출
		System.out.println("클라이언트 요청 처리 종료");
		long end=System.currentTimeMillis();
		System.out.println("요청 처리에 걸린 시간 : "+(end-start));
		
		return obj;
	}//RestController 말고 Controller만 구분하려고 F(구분자 역할)를 붙임 (화면 변경하는 컨트롤러만)
	@After("execution(* com.sist.web.*FController.*(..))") //RestController 말고 Controller만 구분하려고 F(구분자 역할)를 붙임 (화면 변경하는 컨트롤러만)
	public void foodData()
	{
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<FoodVO> tList=dao.foodTop7();
		for(FoodVO vo: tList)
		{
			String address=vo.getAddress();
			String[] addr=address.split(" ");
			vo.setAddress(addr[1].trim()); //구만 출력하려고 자름
		}
		request.setAttribute("tList", tList);
		
		List<NewsVO> nList=mgr.newsListData("맛집"); // 맛집에 대한 뉴스 가져오기
		request.setAttribute("nList", nList);
	}
	
}






























