package cn.com.zhirun.crm.servlet;

import cn.com.zhirun.crm.modle.User;
import cn.com.zhirun.crm.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectUserByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String userName = req.getParameter("userName");
        User user = new User();
        user.setUserName(userName);
        UserService us = new UserService();
        int num = us.checkUserExistByName(user);
        resp.getWriter().write(String.valueOf(num));
    }
}
