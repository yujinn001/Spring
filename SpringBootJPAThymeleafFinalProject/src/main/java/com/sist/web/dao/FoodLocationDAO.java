package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
@Repository
public interface FoodLocationDAO extends JpaRepository<FoodLocationEntity,Integer>{
	// 검색
	@Query(value="select * from food_location "
			   + "where address LIKE concat('%',:address,'%')",nativeQuery = true)
	public List<FoodLocationEntity> foodFindData(@Param("address") String address);
}
