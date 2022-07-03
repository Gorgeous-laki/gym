package com.laki.gymdemo.shiro;

import java.io.Serializable;
import java.util.Date;

/**
 * 封装一个可以显示SimpleAuthenticationInfo可显示公开的信息
 */
public class AccountProfile implements Serializable {
    private Long id;

    private Date create_time;
    private Date update_time;
    private String email;//用户邮箱
    private String headPic;//用户头像
    private String mobile;//用户手机号
}
