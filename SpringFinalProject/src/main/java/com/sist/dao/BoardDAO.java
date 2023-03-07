package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	/*@Select("select no,subject,name,to_char(regdate,'yyyy-mm-dd'),hit,num "
			  + "from (select no,subject,name,regdate,hit,rownum as num "
			  + "from (select /*+index_desc(spring_board sb_no_pk)no,subject,name,regdate,hit "
			  + "from spring_board)) "
			  + "where num between #{start} and #{end}")*/
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	//@Select("select ceil(count(*)/10.0) from spring_board")
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
		
	// 시퀀스가 없는 경우 SelectKey를 사용해서 적용해 준다
	/*@SelectKey(keyProperty ="no",resultType = int.class, before =true,
		     statement = "select nvl(max(no)+1,1) as no from spring_board")
	@Insert("insert into spring_board values( "
		  + "#{no},#{name},#{subject},#{content},#{pwd},sysdate,0)")*/
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	
	/* @Update("update spring_board set "
	   	 + "hit=hit+1 "
	   	 + "where no=#{no}")
	public void boardHitIncrement(int no);
	@Select("select no,name,subject,content,to_char(regdate,'yyyy-mm-dd') as dbday,hit "
		 + "from spring_board "
		 + "where no=#{no}")*/
	public BoardVO boardDetailData(int no)
	{
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}
	/*@Select("select pwd from spring_board where no=#{no}")
	public String boardGetPassword(int no);
	   
	@Update("update spring_board set "
	   		 + "name=#{name},subkect=#{subject},content=#{content} "
	   		 + "where no=#{no}")
	public void boardUpdate(BoardVO vo);
	
	@Delete("delete fron spring_board where no=#{no}")
	public void boardDelete(int no);*/
	public String boardUpdate(BoardVO vo)
	{
		String res="no";
		String db_pwd=mapper.boardGetPassword(vo.getNo()); // 비밀번호 받기
		if(db_pwd.equals(vo.getPwd()))
		{
			mapper.boardUpdate(vo);
			res="yes";
		}
		return res;
	}
	
	public String boardDelete(int no,String pwd)
	   {
	      String res="no";
	      String db_pwd=mapper.boardGetPassword(no);
	      if(db_pwd.equals(pwd))
	      {
	         mapper.boardDelete(no);
	         res="yes";
	      }
	      System.out.println("dao res"+res);
	      return res;
	   }

}
