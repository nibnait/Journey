package com.shakool.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by geekgao on 16-3-29.
 */
public class MyBatisUtils {
    private static SqlSessionFactory sessionFactory;

    static {
        InputStream is = MyBatisUtils.class.getResourceAsStream("mybatisConfig.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSession getSession() throws IOException {
        return sessionFactory.openSession();
    }
}
