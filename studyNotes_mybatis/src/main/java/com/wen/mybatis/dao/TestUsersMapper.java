package com.wen.mybatis.dao;

import com.wen.mybatis.model.TestUsers;

public interface TestUsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(TestUsers record);

    int insertSelective(TestUsers record);

    TestUsers selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TestUsers record);

    int updateByPrimaryKey(TestUsers record);
}