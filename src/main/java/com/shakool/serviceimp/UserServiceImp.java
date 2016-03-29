package com.shakool.serviceimp;

import com.shakool.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by geekgao on 16-3-29.
 */
@Service
public class UserServiceImp implements UserService {

    public boolean verifyWithPhone(String phone, String passwd) {
        return false;
    }

    public boolean verifyWithUserName(String phone, String passwd) {
        return false;
    }
}
