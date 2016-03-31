package com.shakool.controller.user;

import com.shakool.pojo.Suggestion;
import com.shakool.service.FeedBackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by geekgao on 16-3-31.
 */
@Controller
@RequestMapping("/user")
public class FeedBackController {

    @Resource
    private FeedBackService feedBackService;

    @RequestMapping(value = "/addfeedback", method = RequestMethod.GET)
    public @ResponseBody String addFeedBack(@RequestParam(required = false, name = "userid") String userid, @RequestParam(required = false, name = "suggestion") String suggestion, @RequestParam(required = false, name = "qq") String qq, @RequestParam(required = false, name = "email") String email, @RequestParam(required = false, name = "phone") String phone) {
        if (userid == null || userid.equals("") || suggestion == null || suggestion.equals("")) {
            return "{\"errcode\":\"1\",\"msg\":\"参数错误\"}";
        }

        Suggestion suggest = new Suggestion();
        suggest.setUserId(userid);
        suggest.setSuggestion(suggestion);
        suggest.setQq(qq);
        suggest.setPhone(phone);
        suggest.setEmail(email);

        feedBackService.insert(suggest);
        return "{\"errcode\":\"0\",\"msg\":\"正常\"}";
    }
}
