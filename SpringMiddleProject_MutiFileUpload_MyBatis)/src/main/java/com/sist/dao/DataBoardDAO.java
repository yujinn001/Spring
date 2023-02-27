package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;

@Repository
public class DataBoardDAO {
   @Autowired
   private DataBoardMapper mapper;
   
       /*@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,filecount,num "
			  +"FROM (SELECT no,subject,name,regdate,hit,filecount,rownum as num "
			  +"FROM (SELECT /*+ INDEX_DESC(spring_databoard sd_no_pk)no,subject,name,regdate,hit,filecount "
			  +"FROM spring_databoard)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")*/
	   public List<DataBoardVO> databoardListData(Map map)
	   {
		   return mapper.databoardListData(map);
	   }
	   
	   //@Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_databoard")
	   public int databoardTotalPage()
	   {
		   return mapper.databoardTotalPage();
	   }
	   
	   //2.추가 
	   //Sequence
	   /*@SelectKey(keyProperty = "no",resultType = int.class, before = true,
			      statement = "SELECT NVL(MAX(no)+1,1) as no FROM spring_databoard")
	   
	   @Insert("INSERT INTO spring_databoard(no,name,subject,content,pwd,filename,filesize,filecount) "
			  +"VALUES(#{no},#{name},#{subject},#{content},#{pwd},#{filename},#{filesize},#{filecount})")*/
	   public void databoardInsert(DataBoardVO vo)
	   {
		   mapper.databoardInsert(vo);
	   }
	   /* //3. 상세보기
		  @Update("update spring_databoard set "
		   		+ "hit=hit+1 "
		   		+ "where no=#{no}")
		   public void hitIncrment(int no);
		  //3-1. 실제 데이터 가져오기
		  @Select("select no,name,subject,content,to_char(regdate,'yyyy-mm-dd') as dbday,hit, "
		   		+ "filename,filesize,filecount "
		   		+ "from spring_databoard "
		   		+ "where no=#{no}")*/
       public DataBoardVO databoardDetailData(int no)
       {
    	   mapper.hitIncrment(no);
    	   return mapper.databoardDetailData(no);
       }
       /*
        *    // 4. 삭제
		   @Select("select pwd from spring_datboard where no=#{no}")
		   public String databoardGetPassword(int no);
		   
		   @Select("select filename,filesize,filecount from spring_databoard where no=#{no}")*/
	  public DataBoardVO databoardFileInfoData(int no)
	  {
		  return mapper.databoardFileInfoData(no);
	  }
		   
	  //@Delete("delete from spring_databoard where no=#{no}")
	  public boolean databoardDelete(int no,String pwd)
	  {
		  boolean bCheck=false;
		  String db_pwd=mapper.databoardGetPassword(no);
		  if(db_pwd.equals(pwd))
		  {
			  bCheck=true;
			  mapper.databoardDelete(no);
		  }
		  return bCheck;
	  }
	  // 수정 데이터 (hit 수만 증가 시키지 않으면 됨)
	  public DataBoardVO dataBoardUpdataData(int no)
	  {
		  return mapper.databoardDetailData(no);
	  }
	  
	  public boolean pwdCheck(int no,String pwd)
	  {
		  boolean bCheck=false;
		  String db_pwd=mapper.databoardGetPassword(no);
		  if(db_pwd.equals(pwd))
			  bCheck=true;
		  return bCheck;
	  }
	  // @Update("update spring_databoard set "
      // + "name=#{name},subject=#{subject},content=#{content} "
      // + "where no=#{no}")
	  public void databoardUpdate(DataBoardVO vo)
	  {
		  mapper.databoardUpdate(vo);
	  }
	  //public List<DataBoardVO> databoardFindData(Map map);
	  public List<DataBoardVO> databoardFindData(Map map)
	  {
		  return mapper.databoardFindData(map);
	  }
	  
	  //public int FindCount(Map map);
	  public int FindCount(Map map)
	  {
		  return mapper.FindCount(map);
	  }
}
















