package com.shakool.serviceimp;

import com.shakool.dao.FeedBackDao;
import com.shakool.pojo.Suggestion;
import com.shakool.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by geekgao on 16-3-31.
 */
@Service
public class FeedBackServiceImp implements FeedBackService {

    @Autowired
    private FeedBackDao feedBackDao;

    public void insert(Suggestion suggestion) {
        feedBackDao.insert(suggestion);
    }
}
