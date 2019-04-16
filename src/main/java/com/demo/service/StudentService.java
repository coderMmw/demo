package com.demo.service;

import com.demo.entity.Student;

import com.demo.pageUtils.PagingListBean;

import javax.jws.WebMethod;
import java.util.List;
import java.util.Map;


public interface StudentService {
    @WebMethod
    Student getStudentById(int sno);
    @WebMethod
    List<Student> getStudents(int pageIndex, int pageSize);
    @WebMethod
    boolean addStudent(Student student);
}
