package com.sist.web.dao;
import com.sist.web.entity.*;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDAO extends JpaRepository<FoodEntity,Integer>{
	// 쿼리없이 하는 방법 (컬럼값 한개를 갖고 찾는 경우 => findBy) => where cno=1
	List<FoodEntity> findByCno(@Param("cno") Integer cno);
	
	public FoodEntity findByFno(@Param("fno") Integer fno);
}
