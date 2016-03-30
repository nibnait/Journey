package com.shakool.serviceimp;

import com.shakool.dao.UserDao;
import com.shakool.pojo.User;
import com.shakool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by geekgao on 16-3-29.
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    public boolean verifyWithPhone(String phone, String passwd) {
        return false;
    }

    public boolean verifyWithUserName(String phone, String passwd) {
        return false;
    }

    public User getDecalredInfosWithPhone(String phone) {
        return userDao.getDecalredInfosWithPhone(phone);
    }

    public User getDecalredInfosWithUserName(String username) {
        return userDao.getDecalredInfosWithUserName(username);
    }
}
