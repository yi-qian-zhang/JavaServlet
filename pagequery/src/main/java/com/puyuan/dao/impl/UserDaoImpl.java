package com.puyuan.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.puyuan.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;


/**
 * @author clap of thunder
 * @date 2022-04-02 11:35
 * @description
 */
public class UserDaoImpl implements UserDao{
    QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        @Override
        public List<User> findUserByPage(int currentPage, int rows) {
            String sql = "select * from user limit ? , ? ";
            List<User> list = null;
            try {
                list = qr.query(sql, new BeanListHandler<User>(User.class), (currentPage - 1) * rows, rows);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return list;
        }

        @Override
        public int findTotalCount() {
            String sql = "select count(tid) from user";
            Long count = null;
            try {
                count = qr.query(sql, new ScalarHandler<>());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            int c =  count.intValue();
            return c;
        }
    }


