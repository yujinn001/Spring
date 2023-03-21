package com.sist.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sist.food.entity.*;
import java.util.*;

@Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity,Integer>{
	@Query(value="select cno,title,subject,poster,link from project_category",nativeQuery = true)
	public List<CategoryEntity> categoryListData();
}
