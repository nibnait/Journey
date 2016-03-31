package com.shakool.service;

import com.shakool.pojo.User;

/**
 * Created by geekgao on 16-3-29.
 */
public interface UserService {
    boolean verifyWithPhone(String phone,String passwd);

    boolean verifyWithUserName(String phone,String passwd);

    User getDecalredInfosWithPhone(String phone);

    User getDecalredInfosWithUserName(String username);

    boolean phoneExist(String phone);

    void insert(User newUser);
}
