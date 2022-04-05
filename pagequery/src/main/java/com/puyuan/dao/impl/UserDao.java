package com.puyuan.dao.impl;

import com.puyuan.domain.User;

import java.util.List;


/**
 * @author clap of thunder
 * @date 2022-04-02 11:33
 * @description
 */
public interface UserDao{
    //查询当前页面的所有
    List<User> findUserByPage(int currentPage, int rows);
    //总条数
    int findTotalCount();

}
