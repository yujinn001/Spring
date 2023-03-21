package com.sist.board.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.board.entity.BoardEntity;

import java.util.*;

@Repository
public interface BoardDAO  extends JpaRepository<BoardEntity,Integer>{ // id 데이터가 어떤건지에 따라 데이터형이 다르다
	public BoardEntity findByNo(@Param("no") Integer no) ; // 상세보기 (조건절_
	// SELECT * FROM board WHERE no=
	// findByName => 이름으로 찾을경우  , findByNameLike(String name),    findByNameOrSubject => WHERE name= or subject=
	// 자동 : save,remove
	// 검색 : findBy(Column)
	// @Query
	@Query(value="select no,name,subject,content,pwd,regdate,hit "
		       + "from board order by no desc "
		       + "limit :start ,10",nativeQuery=true) // mysql 들어가는 값을 : 
	public List<BoardEntity> boardListData(@Param("start") int start);
	
	@Query(value="select ceil(count(*)/10.0) from board",nativeQuery=true)
	public int boardTotalPage();
	
	// save (insert,update)
	// delete 
}
