package com.shakool.controller.user;

import com.shakool.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by geekgao on 16-3-29.
 * 用户相关控制器
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public @ResponseBody String login(@RequestParam(required = false,name = "phone") String phone, @RequestParam(required = false,name = "username") String username, @RequestParam(required = false,name = "passwd") String passwd) {
        boolean flag;
        if (passwd == null || passwd.equals("")) {
            flag = false;
        } else {
            flag = true;
        }

        boolean isTrueUser = false;
        if (flag) {
            if (phone != null) {
                isTrueUser = userService.verifyWithPhone(phone,passwd);
            } else if (username != null) {
                isTrueUser = userService.verifyWithUserName(username,passwd);
            }
        }

        if (isTrueUser) {

        } else {
            return "{\"errcode\":\"1\",\"msg\":\"用户名或密码错误\"}";
        }

        return null;
    }
@RequestMapping(value = "/register" , method = RequestMethod.POST)
    public @ResponseBody String register() {

        return null;
    }
}
