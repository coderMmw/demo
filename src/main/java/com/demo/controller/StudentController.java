package com.demo.controller;


import com.demo.entity.Student;
import com.demo.pageUtils.Pagelist;
import com.demo.pageUtils.PagingListBean;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController  {
    @Resource
    private StudentService studentService;

    private Pagelist pagelist ;


    @RequestMapping("/getStudents")
    @ResponseBody
    public List<Student> getStudents(HttpServletRequest request, Model model){
        int pageStart = (Integer.parseInt((request.getParameter("pageIndex")))-1)*Integer.parseInt(request.getParameter("pageSize"));
        List<Student> students = studentService.getStudents(pageStart, Integer.parseInt(request.getParameter("pageSize")));
        return students;
    }
}
