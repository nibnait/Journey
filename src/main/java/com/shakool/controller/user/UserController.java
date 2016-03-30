package com.shakool.controller.user;

import com.shakool.pojo.User;
import com.shakool.service.UserService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
        if (passwd == null || passwd.equals("")) {
            return "{\"errcode\":\"2\",\"msg\":\"参数错误\"}";
        }

        boolean isTrueUser = false;
        if (phone != null) {
            isTrueUser = userService.verifyWithPhone(phone,passwd);
        } else if (username != null) {
            isTrueUser = userService.verifyWithUserName(username,passwd);
        }

        User user = null;
        if (isTrueUser) {
            if (phone != null) {
                user = userService.getDecalredInfosWithPhone(phone);
            } else if (username != null) {
                user = userService.getDecalredInfosWithUserName(username);
            }

            JSONObject resultJson = new JSONObject();
            resultJson.put("errcode","0");
            resultJson.put("msg","正确");
            JSONObject userJson = new JSONObject(user);
            resultJson.put("user",userJson);

            return resultJson.toString();
        } else {
            return "{\"errcode\":\"1\",\"msg\":\"用户名或密码错误\"}";
        }
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public @ResponseBody String register(HttpSession session, @RequestParam(required = false,name = "phone") String phone, @RequestParam(required = false,name = "passwd") String passwd, @RequestParam(required = false,name = "nickname") String nickname, @RequestParam(required = false,name = "captcha") String captcha) {
        if (captcha == null || captcha.equals("") || phone == null || phone.equals("") || passwd == null || passwd.equals("") || nickname == null || nickname.equals("")) {
            return "{\"errcode\":\"3\",\"msg\":\"参数错误\"}";
        }
        if (session.getAttribute("captcha") == null || !session.getAttribute("captcha").equals(captcha)) {
            return "{\"errcode\":\"2\",\"msg\":\"验证码错误\"}";
        }

        if (userService.phoneExist(phone)) {
            return "{\"errcode\":\"1\",\"msg\":\"手机号已被注册\"}";
        }

        User newUser = new User();
        newUser.setPhone(phone);
        newUser.setPassword(passwd);
        newUser.setNickname(nickname);
        userService.insertNewUser(newUser);

        return "{\"errcode\":\"0\",\"msg\":\"正常\"}";
    }
}
