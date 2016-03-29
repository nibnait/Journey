package com.shakool.service;

/**
 * Created by geekgao on 16-3-29.
 */
public interface UserService {
    boolean verifyWithPhone(String phone,String passwd);

    boolean verifyWithUserName(String phone,String passwd);
}
