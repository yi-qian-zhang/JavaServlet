package com.puyuan.service;

import com.puyuan.domain.PageBean;
import com.puyuan.domain.User;

/**
 * @author clap of thunder
 * @date 2022-04-02 11:05
 * @description
 */
public interface UserService {
    PageBean<User> findUserByPage(int currentPage, int rows);

}
