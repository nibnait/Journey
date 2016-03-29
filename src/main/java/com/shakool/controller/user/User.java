package com.shakool.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by geekgao on 16-3-29.
 * 用户相关控制器
 */
@Controller
@RequestMapping(value = "user")
public class User {
    @RequestMapping(value = "login" , method = RequestMethod.POST)
    public @ResponseBody String login(@RequestParam("phone") String phone, @RequestParam("username") String username, @RequestParam("passwd") String passwd) {

        return null;
    }
@RequestMapping(value = "register" , method = RequestMethod.POST)
    public @ResponseBody String register() {

        return null;
    }
}
