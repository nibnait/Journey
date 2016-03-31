package com.shakool.dao;

import com.shakool.pojo.User;

/**
 * Created by geekgao on 16-3-29.
 */
public interface UserDao {
    User getDecalredInfosWithPhone(String phone);

    User getDecalredInfosWithUserName(String username);

    User getUserWithPhonePasswd(String phone,String passwd);

    User getUserWithUserNamePasswd(String username,String passwd);

    /**
     *
     * @param phone 手机号码
     * @return 数据库中拥有此手机号码的用户个数，返回-1代表出错
     */
    int phoneCount(String phone);

    /**
     *
     * @param newUser 只会将新用户的phone,password,nickname,registtime存进数据库（注册时只有这几个数据）
     */
    void insert(User newUser);
}
