package com.shakool.mapper;

import com.shakool.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by geekgao on 16-3-29.
 */
public interface UserMapper {
    @Select("select userid,username,nickname,authority,registTime,score,level,sex,birthday,phone,email,image from user where phone = #{0}")
    User getDecalredInfosWithPhone(String phone);

    @Select("select userid,username,nickname,authority,registTime,score,level,sex,birthday,phone,email,image from user where username = #{0}")
    User getDecalredInfosWithUserName(String username);

    @Select("select * from user where phone = #{0} and password = #{1}")
    User getUserWithPhonePasswd(String phone, String passwd);

    @Select("select * from user where username = #{0} and password = #{1}")
    User getUserWithUserNamePasswd(String username, String passwd);
}
