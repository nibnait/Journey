package com.shakool.daoimp;

import com.shakool.dao.UserDao;
import com.shakool.mapper.UserMapper;
import com.shakool.pojo.User;
import com.shakool.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by geekgao on 16-3-29.
 */
@Repository
public class UserDaoImp implements UserDao {

    public User getDecalredInfosWithPhone(String phone) {
        SqlSession sqlSession = null;
        User user = null;
        try {
            sqlSession = MyBatisUtils.getSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            user = mapper.getDecalredInfosWithPhone(phone);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return user;
    }

    public User getDecalredInfosWithUserName(String username) {
        SqlSession sqlSession = null;
        User user = null;
        try {
            sqlSession = MyBatisUtils.getSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            user = mapper.getDecalredInfosWithUserName(username);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return user;
    }

    public User getUserWithPhonePasswd(String phone, String passwd) {
        SqlSession sqlSession = null;
        User user = null;
        try {
            sqlSession = MyBatisUtils.getSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            user = mapper.getUserWithPhonePasswd(phone,passwd);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return user;
    }

    public User getUserWithUserNamePasswd(String username, String passwd) {
        SqlSession sqlSession = null;
        User user = null;
        try {
            sqlSession = MyBatisUtils.getSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            user = mapper.getUserWithUserNamePasswd(username,passwd);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return user;
    }
}
