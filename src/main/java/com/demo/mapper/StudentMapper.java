package com.demo.mapper;

import java.util.List;
import java.util.Map;

import com.demo.pageUtils.PagingList;
import org.apache.ibatis.annotations.Param;
import com.demo.entity.Student;

/**
*  @author zhuxm
*/
public interface StudentMapper {


    int insertStudent(Student object);

    int updateStudent(Student object);

    int update(Student object);

    List<Student> queryStudent(Student object);

    Student queryStudentLimit1(Student object);

    PagingList<Map<String,Object>> getUsers(String spare1, String spare2);


}