package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.*;
@Repository
public class StudentDAO {
   @Autowired
   private StudentMapper mapper;
   
   public List<StudentVO> studentListData(){
      return mapper.studentListData();
   }
   
   @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
   public void studentInsert(StudentVO vo1, StudentVO vo2) {
      mapper.studentInsert(vo1);
      mapper.studentInsert(vo2);
   }
   
   
}