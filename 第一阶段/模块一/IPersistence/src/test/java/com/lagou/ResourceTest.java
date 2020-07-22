package com.lagou;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 *@Author chen_jie
 *@Version 1.0
 *@time 2020/7/22
 **/
public class ResourceTest {
    private SqlSession sqlSession;

    @Before
    public void before()throws Exception{
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        sqlSession = sqlSessionFactory.openSession();
    }

    //查询
    @Test
    public void selectTest()throws Exception{
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    //新增
    @Test
    public void addTest()throws Exception{
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user=new User();
        user.setId(50);
        user.setUsername("测试");
        System.out.println( userDao.addUser(user));
    }
    //修改
    @Test
    public void updateTest()throws Exception{
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user=new User();
        user.setId(50);
        user.setUsername("1111");
        System.out.println( userDao.updateUser(user));
    }
    //删除
    @Test
    public void deleteTest()throws Exception{
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user=new User();
        user.setId(50);
        System.out.println( userDao.deleteUser(user));
    }
}
