package com.demo.dao;


import com.demo.entity.Student;
import com.demo.pageUtils.PagingListBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    List<Student> getStudents(@Param("pageStart") int pageIndex, @Param("pageSize")int pageSize);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

}
