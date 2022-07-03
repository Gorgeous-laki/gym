package com.laki.gymdemo.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.laki.gymdemo.dao.UserDao;
import com.laki.gymdemo.entity.User;
//import com.laki.gymdemo.service.UserService;
import com.laki.gymdemo.utils.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserDao userDao;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;  //判断是不是jwtToken支持
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /**
         * 先进行登录认证
         */
        JwtToken jwtToken = (JwtToken) token;
        String username = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
        User user = userDao.selectById(Long.valueOf(username));
        if(user == null){
            throw new UnknownAccountException("账户不存在");
        }
//        if(user.getStatus() == -1){
//            throw new LockedAccountException("账户状态异常");
//        }
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user,profile);
        return new SimpleAuthenticationInfo(profile,jwtToken.getCredentials(),getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /**
         * 再进行权限管理
         */

        return null;
    }


}
