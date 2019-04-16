package com.demo.service;

import com.demo.entity.User;
import com.demo.pageUtils.PagingListBean;
import javax.jws.WebMethod;
import java.util.Map;


public interface UserService {

    @WebMethod
    User getUserById(int userId);
    @WebMethod
    int updateUser(int userId);
    @WebMethod
    PagingListBean<Map<String,Object>> getUsers(int pageIndex,int pageSize);
    @WebMethod
    int  deleteUserById(int userId);
    @WebMethod
    boolean addUser(User record);
}
