package com.sist.web.dao;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;

@Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity,Integer> {
	@Query(value="select cno,title,poster From project_category",nativeQuery = true)
	public List<CategoryDataMapping> categoryListData();
	
	// 상세보기 => cno를 넘겨서 그 cno에 해당 되는 데이터를 받아온다
	public CategoryEntity  findByCno(@Param("cno") Integer cno);
	//                WHERE cno=1 and title='' => findByCnoAndName(cno,name)
}
