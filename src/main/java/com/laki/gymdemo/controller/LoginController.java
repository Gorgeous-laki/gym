package com.laki.gymdemo.controller;

import cn.hutool.core.lang.Assert;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.laki.gymdemo.common.ResultCom;
import com.laki.gymdemo.dao.UserDao;
import com.laki.gymdemo.entity.User;
import com.laki.gymdemo.entity.UserLogin;
import com.laki.gymdemo.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UserDao userDao;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * 登录页面
     *
     * @return
     */

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 用户登录安全检测
     *
     * @param username
     * @param password
     * @return
     */
//    @PostMapping("/login")
//    public Result login(String username, String password) {
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(token);
//        } catch (AuthenticationException a) {
//            a.printStackTrace();
//        }
//
//        return Result.ok();
//    }

    /**
     * 跳转到系统的主页面
     *
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @RequiresAuthentication    //需要进行登录认证才能进行访问
    @GetMapping("/test")
    public ResultCom test() {
        return ResultCom.success(userDao.selectById(5));
    }

    /**
     * 进行登录认证
     *
     * @param userLogin
     * @param response
     * @return
     */
    @PostMapping("/test")
    public ResultCom test(@RequestBody UserLogin userLogin, HttpServletResponse response) {
        User user = userDao.selectOne(new QueryWrapper<User>().eq("username", userLogin.getUsername()));
        Assert.notNull(user, "用户名不存在");
        if (!user.getPassword().equals(userLogin.getPassword())) {
            return ResultCom.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return ResultCom.success("登陆成功");
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public ResultCom logout() {
        SecurityUtils.getSubject().logout();
        return ResultCom.success(null);
    }


}
