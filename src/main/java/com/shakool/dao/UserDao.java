package com.shakool.dao;

import com.shakool.pojo.User;

/**
 * Created by geekgao on 16-3-29.
 */
public interface UserDao {
    User getDecalredInfosWithPhone(String phone);

    User getDecalredInfosWithUserName(String username);
}
