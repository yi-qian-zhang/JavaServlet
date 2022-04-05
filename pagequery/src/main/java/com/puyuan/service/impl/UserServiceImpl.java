package com.puyuan.service.impl;

import com.puyuan.dao.impl.UserDao;
import com.puyuan.dao.impl.UserDaoImpl;
import com.puyuan.domain.PageBean;
import com.puyuan.domain.User;
import com.puyuan.service.UserService;

import java.util.List;

/**
 * @author clap of thunder
 * @date 2022-04-02 11:27
 * @description
 */
public class UserServiceImpl implements UserService {
        UserDao userDao = new UserDaoImpl();
        @Override
        public PageBean<User> findUserByPage(int currentPage, int rows) {
            PageBean<User> pageBean = new PageBean<>();
            if (currentPage <= 0) {
                currentPage = 1;
            }
            int totalCount = userDao.findTotalCount();
            //计算总页数
            int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
            pageBean.setTotalPage(totalPage);
            if (currentPage > totalPage) {
                currentPage = totalPage;
            }
            List<User> list = userDao.findUserByPage(currentPage, rows);

            pageBean.setTotalCount(totalCount);
            pageBean.setCurrentPage(currentPage);
            pageBean.setRows(rows);
            pageBean.setList(list);


            return pageBean;
        }
    }


