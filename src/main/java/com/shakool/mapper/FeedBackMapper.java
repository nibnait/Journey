package com.shakool.mapper;

import com.shakool.pojo.Suggestion;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by geekgao on 16-3-31.
 */
public interface FeedBackMapper {
    @Insert("insert into feedback values(#{userId},#{suggestion},#{qq},#{email},#{phone})")
    void insert(Suggestion suggestion);
}
