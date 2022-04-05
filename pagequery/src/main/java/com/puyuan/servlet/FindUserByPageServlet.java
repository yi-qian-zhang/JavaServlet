package com.puyuan.servlet;

import com.puyuan.domain.PageBean;
import com.puyuan.domain.User;
import com.puyuan.service.UserService;
import com.puyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author clap of thunder
 * @date 2022-04-02 11:03
 * @description
 */
@WebServlet("/find")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if(null==currentPage||"".equals(currentPage)){
            currentPage="1";
        }
        if(null==rows||"".equals(rows)){
            rows="5";
        }
        //调用service
        UserService userService = new UserServiceImpl();
        PageBean<User> pageBean = userService.findUserByPage(Integer.parseInt(currentPage), Integer.parseInt(rows));
        request.setAttribute("pageBean", pageBean);
        //转发
        try {
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}


