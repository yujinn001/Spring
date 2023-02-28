package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import com.sist.dao.*;
/*
 * -- 프로시저
	-- 목록 출력
	create or  replace procedure boardListData(
	    pStart number,
	    pEnd number,
	    pResult OUT SYS_REFCURSOR-- 값을 받아온다
	)
	IS
	BEGIN
	    OPEN pResult FoR
	    select no, title,poster,msg,address,hit,num
	    from (select no, title,poster,msg,address,hit,rownum as num
	    FRom (select no, title,poster,msg,address,hit
	    from seoul_location order by no asc))
	    where num between pStart and pEnd;
	END;
	/
	
	create or replace procedure seoulLocationDetailData(
	    pNo seoul_location.no%TYPE,
	    pResult OUT SYS_REFCURSOR
	)
	IS
	BEGIN
	    OPEN pResult FOR
	    SELECT no,title,poster,msg,address,hit
	    FROM seoul_location
	    WHERE no=pNO;
	END;
	/
	 * create or replace procedure seoulLocationTotalPage(
    pTotal OUT Number
)
IS
BEGIN
   SELECT ceil(count(*)/20.0) INTO pTotal
   FROM seoul_location;
END;
 */
public interface SeoulMapper {
	/*create or  replace procedure boardListData(
		    pStart number,
		    pEnd number,
		    pResult OUT SYS_REFCURSOR-- 값을 받아온다
		)
		IS
		BEGIN
		    OPEN pResult FoR
		    select no, title,poster,msg,address,hit,num
		    from (select no, title,poster,msg,address,hit,rownum as num
		    FRom (select no, title,poster,msg,address,hit
		    from seoul_location order by no asc))
		    where num between pStart and pEnd;
		END;
		/
	 */
	@Select("{CALL seoulLocationListData(#{pStart,mode=IN,javaType=java.lang.Integer},#{pEnd,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=SeoulMap})}")
	@Options(statementType = StatementType.CALLABLE)
	public List<SeoulVO> seoulLocationListData(Map map);
	
	/*
	 * create or replace procedure seoulLocationDetailData(
	    pNo seoul_location.no%TYPE,
	    pResult OUT SYS_REFCURSOR
	)
	IS
	BEGIN
	    OPEN pResult FOR
	    SELECT no,title,poster,msg,address,hit
	    FROM seoul_location
	    WHERE no=pNO;
	END;
	/
	 */
	@Select("{CALL seoulLocationDetailData(#{pNo,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=SeoulMap})")
	@Options(statementType = StatementType.CALLABLE)
	public SeoulVO seoulDetailData(Map map);
	/*
	 * create or replace procedure seoulLocationTotalPage(
		    pTotal OUT Number
		)
		IS
		BEGIN
		   SELECT ceil(count(*)/20.0) INTO pTotal
		   FROM seoul_location;
		END;
	 */
	//@Select("{CALL seoulLocationTotalPage(pTotal,mode=OUT,javaType=java.lang.Integer)}")
	//@Options(statementType = StatementType.CALLABLE)
	//public int seoulTotalpage(Map map);
	public Integer seoulTotalPage();
}
























