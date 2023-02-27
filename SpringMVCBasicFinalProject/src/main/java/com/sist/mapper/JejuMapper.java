package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.JeJuLocationVO;
import com.sist.vo.JejuFoodVO;
public interface JejuMapper {
   //목록 (여행지)
   @Select("SELECT no,title,poster,num "
         +"FROM (SELECT no,title,poster,rownum as num "
         +"FROM (SELECT no,title,poster "
         +"FROM jejuLocation ORDER BY no ASC)) "
         +"WHERE num BETWEEN #{start} AND #{end}")
   public List<JeJuLocationVO> jejuLocationListData(Map map);
   
   @Select("SELECT CEIL(count(*)/20.0) FROM jejuLocation")
   public int jejuTotalPage();
   
   @Select("select * from jejuLocation where no=#{no}")
   public JeJuLocationVO jejuDetailData(int no);
   
   @Select("select no, title, poster, score, rownum "
         + "from jejuFood "
         + "where rownum<=4 and addr2 like '%'||#{addr}||'%'")
   public List<JejuFoodVO> jejuFoodData(Map map); //인근맛집
}