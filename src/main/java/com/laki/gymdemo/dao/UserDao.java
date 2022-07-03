package com.laki.gymdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laki.gymdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Mapper
@MapperScan("com.laki.gymdemo.dao")
public interface UserDao extends BaseMapper<User> {
//    @Select("select * from gym where username = #{username}")   这是mybatis时候使用的
//    public User getByUsername(String username);

}
