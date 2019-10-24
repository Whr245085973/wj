package com.evan.wj.controller;

import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import com.evan.wj.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    public static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @CrossOrigin     //解决跨域问题
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        //logger.info("用户登录,ok");
        User user = userService.get(username,requestUser.getPassword());
        if (null == user){
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        } else {
            session.setAttribute("user",user);
            return ResultFactory.buildSuccessResult(user);
        }
    }
}
