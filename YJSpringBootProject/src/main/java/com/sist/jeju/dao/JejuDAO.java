package com.sist.jeju.dao;

import java.util.*;
import com.sist.jeju.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/*
HNO         NOT NULL NUMBER        
ALL_CATE_NO          NUMBER        
H_CRAWL_NO           NUMBER        
GRADE                VARCHAR2(20)  
NAME        NOT NULL VARCHAR2(200) 
ADDR        NOT NULL VARCHAR2(200) 
INTRO                CLOB          
TIME        NOT NULL VARCHAR2(100) 
STAR                 NUMBER(2,1)   
ACCOUNT              NUMBER        
HOTEL_IMAGE NOT NULL VARCHAR2(260) 
LIKE_COUNT           NUMBER        
JJIM_COUNT           NUMBER 
 */
@Repository
public interface JejuDAO extends JpaRepository<jejuHotelEntity,Integer>{
	@Query(value="select * "
		       + "from JJ_HOTEL "
		       + " where star>=4.9 order by star desc",nativeQuery = true)
	public List<jejuHotelEntity> jejuStarListData();
	
	
	// 5성급, 4성급, 3성급 출력
	//public jejuEntity findByHno(@Param("hno") Integer hno);
	@Query(value="select * "
		       + "from JJ_HOTEL "
		       + "where grade IN ('5성급','4성급','3성급') order by star",nativeQuery = true)
	public List<jejuHotelEntity> jejucategoryListData();
}
