package com.sist.myapp;

import javax.inject.Inject;
import javax.inject.Qualifier;

import org.aspectj.weaver.NewMethodTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/*
 * 	 어노테이션
 *   --------
 *       = 메모리 할당 (객체 생성)
 *           @Component
 *               |
 *         -------------------------------------------------------
 *         |            |          |            |                |
 *       @Repository  @Service   @Controller   @RestController  @ControllerAdvice
 *       =========================> 기능별로 구분
 *       @Repository  : DAO 클래스를 알려준다
 *       @Service : BI(DAO여러개를 묶어서 사용)
 *       -------------------------------------
 *       @Controller : Model(화면 전환)
 *       @RestController : Model (데이터 전송)
 *       -------------------------- 다른 프로그램과 연동 (Front: Ajax, Vue,React) => JSON
 *       @ControllerAdvice : 공통 예외처리
 *       ------------------------------------------------------ 웹 
 *       
 *       = 주입
 *       	@Qualifier : 특정 객체를 지정
			@Inject : 주입
			@Autowired : 자동 주입 => 스프링에 의해서 객체를 찾아서 자동으로 메모리 주소를 넘겨준다 (객체 주소)
			private  A a;
			public void setA(A a)
			{
			}
			---------------------------p:a-ref(수동)
			@Autowired
			private A a;
			-------------------------------------- 메모리 할당이 아니라 주입 (DI)
			@PostConstructor : init-method
			@PreDestory : destory-method
			
 *       = 공통모듈 : AOP
 *         @ Aspect
 *           @Before
 *           @After
 *           @Around
 *           @After-Restruning
 *           @After-Throwing
 *           
 * 
 */
import java.util.*;
import com.sist.vo.*;
import com.sist.manager.*;
@Component // 스프링에서 관리 요청 (객체 생성 => DI => 객체 소멸) => 메모리 할당 (DL => 자동으로 id가 생성 => mainclass)
//@Component("mc") => 아이디를 주지 않으면 클래스이름의 첫자만 소문자로 아이디가 부여된다
public class MainClass {
	@Autowired //(MainClass)app.getBean("mainClass"); 와 같은 역할
	private MovieManager mm; // 생성된 주소값을 스프링으로 부터 받아 온다
	// 지역변수를 제어할 수 없다
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		/*MainClass mc=(MainClass)app.getBean("mainClass"); // component-scan으로 component사용한 곳을 읽어온다 -> 아이디값이 없어서 자동 생성
		while(true) // 한번 수행에서 5. 종료하기 전까지 계속 실행한다
		{
			Scanner sc= new Scanner(System.in);
			System.out.println("====== menu =====");
			System.out.println("1. 일일 박스 오피스");
			System.out.println("2. 실시간 예매");
			System.out.println("3. 좌석 점유율");
			System.out.println("4. 온라인상영관 일일");
			System.out.println("5. 종료");
			System.out.println("=================");
			System.out.println("메뉴 선택");
			int no = sc.nextInt();
			if(no==5) break;
			List<MovieVO> list=mc.mm.movieListData(no);
			for(MovieVO vo:list)
			{
				System.out.println(vo.getRank()+" "+vo.getTitle()+" "+vo.getGenre()+" "+vo.getDirector());
			}
		}*/
		NewsManager n=(NewsManager)app.getBean("newsManager"); // 자동 아이디 설정 (클래스이름- 맨 첫자 소문자)
		Scanner scan =new Scanner(System.in);
		System.out.println("검색어 입력");
		String fd=scan.next();
		List<NewsVO> list=n.newsListData(fd);
		for(NewsVO vo:list)
		{
			System.out.println(vo.getTitle());
			System.out.println(vo.getDescription());
			System.out.println(vo.getPubDate());
			System.out.println("==========================================");
			
		}
		
		
	}

}
