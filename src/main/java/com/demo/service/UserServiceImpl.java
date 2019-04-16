package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.entity.User;
import com.demo.pageUtils.GetPageList;
import com.demo.pageUtils.PagingListBean;
import com.demo.utils.EntityUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("userService")
public class UserServiceImpl implements UserService {



    @Resource
    private UserDao userDao;

    @Override
    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }
    @Override
    public boolean addUser(User record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }



    @Override
    public int updateUser(int userId) {
        User user = new User();
        user.setId(userId);
        return userDao.updateByPrimaryKey(user);
    }

    @Override
    public PagingListBean<Map<String,Object>> getUsers(int pageIndex, int pageSize) {
        List<Map<String,Object>> list = new ArrayList<>();
        List<Map<String,Object>> list1;
        List<User> users = userDao.getUsers(pageIndex, pageSize);
        PagingListBean<Map<String,Object>> page = new PagingListBean<>();
        GetPageList gp = new GetPageList();
        for(int i=0;i<users.size();i++){
            Map<String, Object> stringObjectMap = EntityUtils.toMap(users.get(i), "id", "userName", "age", "password");
            list.add(stringObjectMap);
        }
        list1 = gp.getPageList(pageIndex, pageSize, list);
        page.setTotal(list1.size());
        page.setItems(list1);
        return page;
    }

    @Override
    public int deleteUserById(int userId) {

        return userDao.deleteByPrimaryKey(userId);
    }



}
