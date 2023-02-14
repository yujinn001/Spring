package com.sist.dao;
// xml을 이용해서 설정하는 법

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class StudentDAO extends SqlSessionDaoSupport{
	// 1. 데이터 추가
	/*
	 * <insert id="studentInsert" parameterType="StudentVO"><!-- insert일 때는 반환값이 void여서 resultType이 없다 -->
	    <!-- sequence 내용 추가할때는 selectKey -->
	    <selectKey keyProperty="hakbun" resultType="int" order="BEFORE">
	      SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student 
	    </selectKey>
	    INSERT INTO student VALUES(#{hakbun},#{name},#{kor},#{eng},#{math}) <!--SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student   -->
	    <!-- 
	         ${id} request.getAttribute("id")
	         #{name} = vo.getName()
	         #{eng} =vo.getEng()
	     -->
	    </insert>
	   
	    map.put("studentInsert", INSERT INTO student VALUES(#{hakbun},#{name},#{kor},#{eng},#{math}) )
	 */
	public void studentInsert(StudentVO vo)
	{
		getSqlSession().insert("studentInsert",vo);
	}
	
	// 2. 데이터 목록
	public List<StudentVO> studentListData()
	{
		return getSqlSession().selectList("studentListData");
	}
	
	//3. 데이터 검색 
	/*
	 * <select id="studentDetailData" resultType="StudentVO" parameterType="int">
	     <include refid="select-data"/> <!-- 반복을 제거하는 방식 -->
	    WHERE hakbun=#{hakbun} 
	  </select>
	 */
	public StudentVO studentDetailData(int hakbun)
	{
		return getSqlSession().selectOne("studentDetailData",hakbun);
	}
	
	// 4. 데이터 수정
	/* <update id="studentUpdate" parameterType="StudentVO">
		   UPDATE student SET
		   kor=#{kor},eng=#{eng},math=#{math}
		   WHERE hakbun=#{hakbun}
		  </update>
	 */
	public void studentUpdate(StudentVO vo)
	{
		getSqlSession().update("studentUpdate",vo); 
	}
	/*
	 * <delete id="studentDelete" parameterType="int">
		   DELETE FROM student
		   WHERE hakbun=#{hakbun}
		  </delete>
	 */
	public void studentDelete(int hakbun)
	{
		getSqlSession().delete("studentDelete",hakbun);
	}
}




























