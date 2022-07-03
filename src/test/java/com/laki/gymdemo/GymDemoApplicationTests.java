package com.laki.gymdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.laki.gymdemo.dao.UserDao;
import com.laki.gymdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GymDemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println(userDao.selectById(5).getUsername()+userDao.selectById(5).getPassword());
    }

    @Test
    void testGetPage(){
        /**
         * mybatis-plus分页查询
         */
        IPage page = new Page(0,1);
        userDao.selectPage(page,null);
    }
    @Test
    void testGetCondition(){
        /**
         * 条件查询
         */
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like("email","844473341");
        System.out.println(userDao.selectList(qw));
    }
    @Test
    void testGetCondition2(){
        String name = null;
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null,User::getEmail,name);  //防止应字段名写错而造成失误（安全性强）
        System.out.println(userDao.selectList(lqw));

    }

}
