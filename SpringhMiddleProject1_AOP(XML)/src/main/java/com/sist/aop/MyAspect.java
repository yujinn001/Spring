package com.sist.aop;
/*
 *   aspect : 공통 모듈 (자주 호출) 
 *   --------------------------
 *     공통 / 핵심
 *   OOP는 공통으로 사용시에 => 한개의 클래스를 이용할 때 메소드
 *                                             -----
 *                           = getConnection(), disConnection()
 *                         여러개 클래스 이용할 때 클래스
 *                           = CreateConnection 
 *   스프링에서는  => 공통으로 사용되는 부분을 자동화 처리 => AOP 
 *   AOP 처리 => 로그 파일, 트랜잭션 처리, 보안
 *   -------
 *     1) 시점 (언제 호출) => JoinPoint 
 *     <공통 모듈을 모아주는 시점)
 *        = Before
 *        = After
 *        = AfterReturning
 *        = AfterThrowing
 *        = Around
 *        
 *        public String display()
 *        {
 *           @Before(getConnection()) => try~catch절전에 수행할 문장
 *        	 try
 *        	 {
 *         		 ===================== Around (처리 시간 계산) => setAutoCommit(false)
 *         			소스코딩
 *         		 ===================== Commit
 *        
 *           }catch(Exception ex)
 *           {
 *           	에러발생시 => AfterThrowing =>RollBack()
 *           }
 *           finally
 *           { 
 *           	@After =>  disConnection() 
 *           }
 *           
 *           return "" => AfterReturning(정상수행시) => 리턴값을 받아서 처리 
 *        }
 *     2) 어떤 메소드에서 자동화 => PointCut
 *          execution("* com.sist.main.*.*(..)")
 *                    -- ============= - - -- 모든 매개 변수
 *                    |                | |
 *                   리턴형       모든클래스 메소드
 *         within("com.sist.main.*") ==> 패키지 단위로 모든 클래스에 적용
 *     3) Advice(JoinPoint+PointCut) ==> Aspect 
 *     4) Weaving : 통합 ==> Proxy패턴 (대리자)
 *     -----------------------------------------------------------
 *     예) 
 *         public class A
 *         {
 *         		public void display()
 *         		{
 *         		}
 *         		// 이게 호출되는게 아니라
 *         }
 *         // 내가 지정된 메소드 호출
 *         public class Proxy
 *         {
 *         		private A a;
 *         		public Proxy(A a)
 *         		{
 *         		}
 *         		public void display
 *         		{
 *                 @Before
 *                 System.out.println("Before");
 *                 a.display()
 *                 @After
 *                 System.out.println("After");
 *         		}
 *         
 *         }
 */
public class MyAspect {
	public void getConnection()
	{
		System.out.println("오라클 연결...");
	}
	public void disConnection()
	{
		System.out.println("오라클 닫기");
	}
}

























