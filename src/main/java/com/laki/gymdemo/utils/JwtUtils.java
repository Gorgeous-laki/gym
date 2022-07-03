package com.laki.gymdemo.utils;

import cn.hutool.log.Log;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.Date;
@Data
@Slf4j
@Component
@ConfigurationProperties(prefix = "laki.jwt")
public class JwtUtils {
    private String secret;
    private long expire;
    private String header;
    /**
     * 生成jwt token
     */
    public String generateToken(long userId){
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,"f4dff3338493838f33939fe33")
                .compact();
    }
    public Claims getClaimByToken(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            log.debug("validate is token error",e);
            return null;
        }
    }

    /**
     * token是否过期
     * @param expiration
     * @return  true为过期了
     */
    public boolean isTokenExpired(Date expiration){
        return expiration.before(new Date());
    }
}