package com.demo.service;

import com.demo.dao.StudentDao;

import com.demo.entity.Student;

import com.demo.pageUtils.PagingList;
import com.demo.pageUtils.PagingListBean;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public Student getStudentById(int sno) {
        return studentDao.selectByPrimaryKey(sno);
    }

    @Override
    public boolean addStudent(Student student){
        boolean result = false;
        try {
            studentDao.insertSelective(student);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    @Override
   public  List<Student> getStudents(int pageIndex, int pageSize){
        List<Student> students = studentDao.getStudents(pageIndex, pageSize);

        return students;
    }
}
