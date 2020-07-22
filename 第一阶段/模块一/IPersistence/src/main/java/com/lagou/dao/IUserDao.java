package com.lagou.dao;
/**
 *@Author chen_jie
 *@Version 1.0
 *@time 2020/7/22
 **/

import com.lagou.pojo.User;

import java.util.List;

public interface IUserDao {

    //查询所有用户
    public List<User> findAll() throws Exception;
    //新增
    public int addUser(User user);
    //修改
    public int updateUser(User user);
    //删除
    public int deleteUser(User user);


}