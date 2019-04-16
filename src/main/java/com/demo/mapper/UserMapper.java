package com.demo.mapper;

import com.demo.entity.User;
import com.demo.pageUtils.PagingListBean;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int insert(User record);
    User getUserById(int userId);
    boolean addUser(User record);
    int insertSelective(User record);
    List<Map<String,Object>> getUsers(String spare1, String spare2);
}