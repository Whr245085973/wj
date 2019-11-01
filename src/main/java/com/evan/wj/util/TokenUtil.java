package com.evan.wj.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.evan.wj.pojo.User;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: Mr.Wu
 * @create: 2019/11/1 11:09
 **/
public class TokenUtil {
    public String getToken(User user) {
        String token = JWT.create().withAudience(Integer.toString(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PassToken {
        boolean required() default true;
    }

    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UserLoginToken {
        boolean required() default true;
    }
}
