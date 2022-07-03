package com.laki.gymdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.laki.gymdemo.entity.common.StaticConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户后台实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("gym_user")
public class User {
    public static final Integer ADMIN_USER_STATUS_ENABLE = 1;//用户状态正常可用
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private Date create_time;
    private Date update_time;
    private String email;//用户邮箱
    private String headPic;//用户头像
    private String mobile;//用户手机号
    private String password;  //登录密码
    private Integer sex = StaticConstants.SEX_UNKONW;//用户性别 定义于StaticConstants公共常量类
    private Integer status = ADMIN_USER_STATUS_ENABLE;  //用户状态默认可用
    private String username;   //用户名
    private Long role_id;


    public User(String username, String password) {

    }
}
