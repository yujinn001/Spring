package com.sist.mapper;
import java.util.*;
/*  
 *  <trim>
 *  <foreach>
 *  <if>
 *  <choose>
 *  <when>
 */
import com.sist.dao.EmpVO;
// �޼ҵ� id�� ����!
public interface EmpMapper {
	
  /*<select id="empNameListData" resultType="string">
      select distinct ename from emp  
    </select>
  */
	public List<String> empNameListData();
	
	/*
	 * <select id="empInfoData" resultType="EmpVO" parameterType="hashmap">
     	select * from emp
	 */
	public List<EmpVO> empInfoData(Map map); // 1���� EmpVO �������� List
	




}
