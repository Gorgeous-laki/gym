package com.laki.gymdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laki.gymdemo.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleDao extends BaseMapper<Role> {

}
