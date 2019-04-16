package com.demo.controller;

import com.demo.entity.User;
import com.demo.pageUtils.PagingListBean;
import com.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser1")
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public PagingListBean<Map<String,Object>> getUsers(HttpServletRequest request, Model model){
        PagingListBean<Map<String,Object>> users = userService.getUsers(Integer.parseInt(request.getParameter("pageIndex")), 5);
        System.out.println(users);
        return users;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public boolean addUser(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User();
        user.setUserName(userName);
        if(password.equals(password1)){

        }else{
            return false;
        }
        user.setPassword(password);
        user.setId(userId);
        user.setAge(age);

        return this.userService.addUser(user);
    }

    @RequestMapping(value="/home/page")
    @ResponseBody
    public ModelAndView goHome(){
        System.out.println("go to the home page!");
        ModelAndView mode = new ModelAndView();
        mode.addObject("name", "zhangsan");
        mode.setViewName("index");
        mode.getModel();
        return mode;
    }



}
